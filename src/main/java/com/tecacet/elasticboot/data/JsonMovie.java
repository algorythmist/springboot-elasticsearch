package com.tecacet.elasticboot.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class JsonMovie {

    private String title;
    private int year;
    @JsonDeserialize
    private Info info;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public class Info {

        @JsonProperty("release_date")
        private LocalDate releaseDate;
        @JsonProperty("running_time_secs")
        private int runningTime;
        private Double rating;
        @JsonProperty("image_url")
        private String imageUrl;
        private String plot;
        private final List<String> directors = new ArrayList<>();
        private final List<String> genres = new ArrayList<>();
        private final List<String> actors = new ArrayList<>();
    }

    public List<String> getDirectors() {
        return info.getDirectors();
    }

    public List<String> getActors() {
        return info.getActors();
    }

    public List<String> getGenres() {
        return info.getGenres();
    }

    public LocalDate getReleaseDate() {
        return info.getReleaseDate();
    }

    public String getPlot() {
        return info.getPlot();
    }

    public int getDuration() {
        return info.getRunningTime() / 60;
    }

    public Double getRating() {
        return info.getRating();
    }

    public String getImageUrl() {
        return info.getImageUrl();
    }

}
