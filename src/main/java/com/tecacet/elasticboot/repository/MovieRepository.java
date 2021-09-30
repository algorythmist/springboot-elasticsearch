package com.tecacet.elasticboot.repository;

import com.tecacet.elasticboot.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieRepository extends ElasticsearchRepository<Movie, String>  {

    Page<Movie> findByTitle(String title, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"actors\": \"?0\"}}]}}")
    Page<Movie> findByActorsNameUsingCustomQuery(String actor, Pageable pageable);
}
