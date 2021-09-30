package com.tecacet.elasticboot.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tecacet.elasticboot.domain.Movie;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse a JSON file containing movie information
 *
 * @author dimitri
 * @see JsonMovie
 */
public class MovieLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MovieConverter movieConverter = new MovieConverter();

    public MovieLoader() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Movie> load(String filename) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream(filename);
        List<JsonMovie> jsonMovies =  objectMapper.readValue(is, new TypeReference<>() {});
        return jsonMovies.stream().map(movieConverter).collect(Collectors.toList());
    }
}
