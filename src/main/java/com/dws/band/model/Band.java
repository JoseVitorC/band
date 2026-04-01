package com.dws.band.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Band(
        String id,
        String name,
        String image,
        String genre,
        String biography,
        Long numPlays,
        List<String> albums
) {}
