package com.tecacet.elasticboot.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "movie")
@Getter
@Builder
public class Movie {

    @Id
    private String id; //TODO: UUID

    private String title;
    private int year;
    @Field(type = FieldType.Date, format = DateFormat.basic_date, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private int runningTime;
    private Double rating;
    private String imageUrl;
    private String plot;
    private final List<String> directors;
    private final List<String> genres;
    private final List<String> actors;

    @Override
    public String toString() {
        String rating = getRating() == null ? "No rating" : getRating().toString();
        return String.format("%s (%d): %s", getTitle(), getYear(), rating);
    }

}
