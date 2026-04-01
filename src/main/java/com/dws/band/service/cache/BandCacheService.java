package com.dws.band.service.cache;

import com.dws.band.client.ApiFeignClient;
import com.dws.band.model.Band;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BandCacheService {

    private final ApiFeignClient client;

    @Cacheable(value = "band", key = "#id")
    public Band getById(String id) {
        return client.fetchBandById(id);
    }
}
