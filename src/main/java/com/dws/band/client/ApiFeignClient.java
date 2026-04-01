package com.dws.band.client;

import com.dws.band.model.Album;
import com.dws.band.model.Band;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "music-api", url = "${api.base-url}")
public interface ApiFeignClient {

    @GetMapping("/api/bands")
    List<Band> fetchAllBands(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sort
    );

    @GetMapping("/api/bands/{id}")
    Band fetchBandById(@PathVariable String id);

    @GetMapping("/api/albums")
    List<Album> fetchAllAlbums(
            @RequestParam int page,
            @RequestParam int size
    );

    @GetMapping("/api/albums/{id}")
    Album fetchAlbumById(@PathVariable String id);
}
