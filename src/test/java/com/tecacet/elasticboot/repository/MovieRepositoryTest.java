package com.tecacet.elasticboot.repository;

import com.tecacet.elasticboot.data.MovieLoader;
import com.tecacet.elasticboot.domain.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    @AfterEach
    void cleanUp() {
        movieRepository.deleteAll();
    }

    @Test
    void crud() throws IOException {
        MovieLoader movieParser = new MovieLoader();
        List<Movie> movies = movieParser.load("moviedata.json");
        movieRepository.saveAll(movies);

        assertEquals(4609, movieRepository.count());

        Page<Movie> moviePage1 = movieRepository.findByTitle("A Man Apart", Pageable.ofSize(10));
        assertEquals("[A Man Apart (2003): 5.9]", moviePage1.get().collect(Collectors.toList()).toString());

        Page<Movie> moviePage2 = movieRepository.findByActorsNameUsingCustomQuery("Naomi Watts", Pageable.ofSize(25));
        assertEquals(19, moviePage2.get().count());

    }
}