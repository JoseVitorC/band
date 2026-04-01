package com.dws.band.controller;

import com.dws.band.dto.BandResponse;
import com.dws.band.dto.PageResponse;
import com.dws.band.model.Band;
import com.dws.band.service.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bands")
@RequiredArgsConstructor
public class BandController {

    private final BandService bandService;

    @GetMapping
    public ResponseEntity<PageResponse<Band>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(bandService.getAll(name, sort, page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandResponse> getById(@PathVariable String id) {
        //validate id !=null
        return ResponseEntity.ok(bandService.getById(id));
    }
}
