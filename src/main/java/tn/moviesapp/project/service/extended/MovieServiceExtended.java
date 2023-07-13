package tn.moviesapp.project.service.extended;

import static java.util.Objects.isNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.moviesapp.project.domain.Category;
import tn.moviesapp.project.domain.Movie;
import tn.moviesapp.project.domain.Staff;
import tn.moviesapp.project.repository.extended.CategoryRepositoryExtended;
import tn.moviesapp.project.repository.extended.MovieRepositoryExtended;
import tn.moviesapp.project.repository.extended.StaffRepositoryExtended;
import tn.moviesapp.project.service.MovieService;
import tn.moviesapp.project.service.dto.AdminUserDTO;

@Service
@Transactional
public class MovieServiceExtended extends MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceExtended.class);

    private final MovieRepositoryExtended movieRepositoryExtended;
    private final CategoryRepositoryExtended categoryRepositoryExtended;

    private final StaffRepositoryExtended staffRepositoryExtended;

    public MovieServiceExtended(
        MovieRepositoryExtended movieRepositoryExtended,
        CategoryRepositoryExtended categoryRepositoryExtended,
        StaffRepositoryExtended staffRepositoryExtended
    ) {
        super(movieRepositoryExtended);
        this.movieRepositoryExtended = movieRepositoryExtended;
        this.categoryRepositoryExtended = categoryRepositoryExtended;
        this.staffRepositoryExtended = staffRepositoryExtended;
    }

    public Movie CreateMovie(Movie movie) {
        // Vérifier l'existance d'une catégorie , si la category n'existe pas on va la creér

        Set<Category> categories = movie
            .getCategories()
            .stream()
            .map(category -> {
                if (isNull(category.getId())) {
                    Category saved = categoryRepositoryExtended.save(category);
                    return saved;
                }
                return category;
            })
            .collect(Collectors.toSet());
        movie.setCategories(categories);
        // Vérifier l'existance des Staff , si la category n'existe pas on va la creér

        Set<Staff> staffMovie = movie
            .getMembreStaffs()
            .stream()
            .map(staff -> {
                if (isNull(staff.getId())) {
                    Staff savedStaff = staffRepositoryExtended.save(staff);
                    return savedStaff;
                }
                return staff;
            })
            .collect(Collectors.toSet());
        movie.setMembreStaffs(staffMovie);

        return movieRepositoryExtended.save(movie);
    }

    public Set<Movie> getMoviesSearch(String search) {
        return movieRepositoryExtended.getMoviesSearch(search);
    }
}
