package com.dws.band.service;

import com.dws.band.client.ApiFeignClient;
import com.dws.band.dto.PageResponse;
import com.dws.band.model.Album;
import com.dws.band.service.cache.AlbumCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final ApiFeignClient client;
    private final AlbumCacheService albumCacheService;

    public PageResponse<Album> getAll(int page, int size) {
        List<Album> albums = client.fetchAllAlbums(page, size);
        return PageResponse.of(albums, page, size);
    }

    public Album getById(String id) {
        return albumCacheService.getById(id);
    }
}
