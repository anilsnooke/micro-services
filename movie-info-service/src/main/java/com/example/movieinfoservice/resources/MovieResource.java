package com.example.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        MovieSummary movieSummary = new MovieSummary();
        movieSummary.setId(movieId);
        movieSummary.setOverview("Overview");
        movieSummary.setTitle("Title");
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

    }

}
