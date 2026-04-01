package com.dws.band.service;

import com.dws.band.model.Album;
import com.dws.band.service.cache.AlbumCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumCacheService albumCacheService;

    public List<Album> getAll() {
        return albumCacheService.getAll();
    }

    public Album getById(String id) {
        return albumCacheService.getById(id);
    }
}
