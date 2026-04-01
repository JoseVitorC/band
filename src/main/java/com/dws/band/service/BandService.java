package com.dws.band.service;

import com.dws.band.client.ApiFeignClient;
import com.dws.band.dto.BandResponse;
import com.dws.band.dto.PageResponse;
import com.dws.band.model.Album;
import com.dws.band.model.Band;
import com.dws.band.service.cache.AlbumCacheService;
import com.dws.band.service.cache.BandCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BandService {

    private final ApiFeignClient client;
    private final BandCacheService bandCacheService;
    private final AlbumCacheService albumCacheService;

    public PageResponse<Band> getAll(String name, String sort, int page, int size) {
        List<Band> bands = client.fetchAllBands(page, size, name, sort);
        return PageResponse.of(bands, page, size);
    }

    public BandResponse getById(String id) {
        Band band = bandCacheService.getById(id);

        List<Album> albums = band.albums().stream()
                .map(albumCacheService::getById)
                .toList();

        return BandResponse.from(band, albums);
    }
}
