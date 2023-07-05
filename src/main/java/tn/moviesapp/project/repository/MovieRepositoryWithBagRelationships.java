package tn.moviesapp.project.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import tn.moviesapp.project.domain.Movie;

public interface MovieRepositoryWithBagRelationships {
    Optional<Movie> fetchBagRelationships(Optional<Movie> movie);

    List<Movie> fetchBagRelationships(List<Movie> movies);

    Page<Movie> fetchBagRelationships(Page<Movie> movies);
}
