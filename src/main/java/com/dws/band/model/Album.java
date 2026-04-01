package com.dws.band.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Album(
        String id,
        String name,
        Instant releasedDate,
        String image,
        Band band,
        List<Track> tracks
) {}
