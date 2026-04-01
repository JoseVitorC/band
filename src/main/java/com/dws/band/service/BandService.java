package com.dws.band.service;

import com.dws.band.dto.BandResponse;
import com.dws.band.model.Album;
import com.dws.band.model.Band;
import com.dws.band.service.cache.AlbumCacheService;
import com.dws.band.service.cache.BandCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BandService {

    private final BandCacheService bandCacheService;
    private final AlbumCacheService albumCacheService;

    public List<Band> getAll(String name, String sort) {
        List<Band> bands = bandCacheService.getAll();

        bands = filterByName(name, bands);

        bands = filterBySortValue(sort, bands);

        return bands;
    }

    private List<Band> filterByName(String name, List<Band> bands) {
        if (name != null && !name.isBlank()) {
            String query = name.toLowerCase();
            bands = bands.stream()
                    .filter(b -> b.name().toLowerCase().contains(query))
                    .toList();
        }
        return bands;
    }

    private static List<Band> filterBySortValue(String sort, List<Band> bands) {
        if (sort == null || bands.isEmpty()) return bands;

        return switch (sort.toLowerCase()) {
            case "popularity" -> bands.stream()
                    .sorted(Comparator.comparingLong(Band::numPlays).reversed())
                    .toList();
            case "name" -> bands.stream()
                    .sorted(Comparator.comparing(Band::name, String.CASE_INSENSITIVE_ORDER))
                    .toList();
            default -> bands;
        };
    }

    public BandResponse getById(String id) {
        Band band = bandCacheService.getById(id);

        List<Album> albums = band.albums().stream()
                .map(albumCacheService::getById)
                .toList();

        return BandResponse.from(band, albums);
    }
}
