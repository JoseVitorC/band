package com.dws.band.controller;

import com.dws.band.dto.BandResponse;
import com.dws.band.model.Band;
import com.dws.band.service.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bands")
@RequiredArgsConstructor
public class BandController {

    private final BandService bandService;

    @GetMapping
    public ResponseEntity<List<Band>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sort) {
        return ResponseEntity.ok(bandService.getAll(name, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(bandService.getById(id));
    }
}
