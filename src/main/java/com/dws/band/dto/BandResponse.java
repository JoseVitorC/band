package com.dws.band.dto;

import com.dws.band.model.Album;
import com.dws.band.model.Band;

import java.util.List;

public record BandResponse(
        String id,
        String name,
        String image,
        String genre,
        String biography,
        Long numPlays,
        List<Album> albums
) {
    public static BandResponse from(Band band, List<Album> albums) {
        return new BandResponse(
                band.id(),
                band.name(),
                band.image(),
                band.genre(),
                band.biography(),
                band.numPlays(),
                albums
        );
    }
}
