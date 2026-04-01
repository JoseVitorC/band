package com.dws.band.controller;

import com.dws.band.dto.PageResponse;
import com.dws.band.model.Album;
import com.dws.band.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity<PageResponse<Album>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(albumService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable String id) {
        //validate id !=null
        return ResponseEntity.ok(albumService.getById(id));
    }
}
