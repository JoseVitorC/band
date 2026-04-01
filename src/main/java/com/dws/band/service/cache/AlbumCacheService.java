package com.dws.band.service.cache;

import com.dws.band.client.ApiFeignClient;
import com.dws.band.model.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumCacheService {

    private final ApiFeignClient client;

    @Cacheable(value = "album", key = "#id")
    public Album getById(String id) {
        return client.fetchAlbumById(id);
    }
}
