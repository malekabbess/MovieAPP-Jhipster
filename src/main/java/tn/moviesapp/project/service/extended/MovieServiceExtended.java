package tn.moviesapp.project.service.extended;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.moviesapp.project.repository.extended.MovieRepositoryExtended;
import tn.moviesapp.project.service.MovieService;
import tn.moviesapp.project.service.dto.AdminUserDTO;

@Service
@Transactional
public class MovieServiceExtended extends MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceExtended.class);

    private final MovieRepositoryExtended movieRepositoryExtended;
    private final MovieService movieService;

    public MovieServiceExtended(MovieRepositoryExtended movieRepositoryExtended, MovieService movieService) {
        super(movieRepositoryExtended);
        this.movieRepositoryExtended = movieRepositoryExtended;
        this.movieService = movieService;
    }
}
