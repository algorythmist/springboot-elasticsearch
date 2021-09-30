package com.tecacet.elasticboot.data;

import com.tecacet.elasticboot.domain.Movie;

import java.util.UUID;
import java.util.function.Function;

public class MovieConverter implements Function<JsonMovie, Movie> {

    @Override
    public Movie apply(JsonMovie jsonMovie) {
        return Movie.builder()
                .id(UUID.randomUUID().toString())
                .title(jsonMovie.getTitle())
                .year(jsonMovie.getYear())
                .releaseDate(jsonMovie.getReleaseDate())
                .imageUrl(jsonMovie.getImageUrl())
                .plot(jsonMovie.getPlot())
                .rating(jsonMovie.getRating())
                .runningTime(jsonMovie.getDuration())
                .actors(jsonMovie.getActors())
                .directors(jsonMovie.getDirectors())
                .genres(jsonMovie.getGenres())
                .build();
    }
}
