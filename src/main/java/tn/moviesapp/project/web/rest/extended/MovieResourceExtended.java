package tn.moviesapp.project.web.rest.extended;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tn.moviesapp.project.domain.Movie;
import tn.moviesapp.project.service.extended.MovieServiceExtended;
import tn.moviesapp.project.web.rest.errors.BadRequestAlertException;

@RestController
@RequestMapping("/api/movies")
public class MovieResourceExtended {

    private final Logger log = LoggerFactory.getLogger(MovieResourceExtended.class);

    private static final String ENTITY_NAME = "Movie";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MovieServiceExtended movieExtraServiceExtended;

    public MovieResourceExtended(MovieServiceExtended movieExtraServiceExtended) {
        this.movieExtraServiceExtended = movieExtraServiceExtended;
    }

    @PostMapping("/create")
    public ResponseEntity<Movie> createMovieExtra(@RequestBody Movie movie) throws URISyntaxException {
        log.debug("REST request to save movie : {}", movie);
        if (movie.getId() != null) {
            throw new BadRequestAlertException("A new userExtra cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Movie result = movieExtraServiceExtended.CreateMovie(movie);
        return ResponseEntity
            .created(new URI("/api/movies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @GetMapping("/movies")
    public Set<Movie> getAllMoviesByFilter(@RequestParam(required = false, name = "search") String search) {
        log.debug("REST request to get the movie you looking for");
        return movieExtraServiceExtended.getMoviesSearch(search);
    }
}
