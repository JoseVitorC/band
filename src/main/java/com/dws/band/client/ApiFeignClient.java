package com.dws.band.client;

import com.dws.band.model.Album;
import com.dws.band.model.Band;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "music-api", url = "${api.base-url}")
public interface ApiFeignClient {

    @GetMapping("/api/bands")
    List<Band> fetchAllBands();

    @GetMapping("/api/bands/{id}")
    Band fetchBandById(@PathVariable String id);

    @GetMapping("/api/albums")
    List<Album> fetchAllAlbums();

    @GetMapping("/api/albums/{id}")
    Album fetchAlbumById(@PathVariable String id);
}
