package com.dws.band.controller;

import com.dws.band.model.Album;
import com.dws.band.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAll() {
        return ResponseEntity.ok(albumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable String id) {
        return ResponseEntity.ok(albumService.getById(id));
    }
}
