package com.dws.band.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Track(
        String id,
        String name,
        String duration
) {}
