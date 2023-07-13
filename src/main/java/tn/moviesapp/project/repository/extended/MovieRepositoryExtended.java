package tn.moviesapp.project.repository.extended;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.moviesapp.project.domain.Movie;
import tn.moviesapp.project.repository.MovieRepository;
import tn.moviesapp.project.repository.MovieRepositoryWithBagRelationships;

@Repository
public interface MovieRepositoryExtended extends MovieRepositoryWithBagRelationships, MovieRepository {
    @Query(
        "select m from Movie m left join m.categories  category " +
        "left join m.membreStaffs staff " +
        "where (" +
        "(:search is null ) or (m.name like %:search%)" +
        " or (cast(m.publishDate AS string) like %:search% )" +
        " or (category.name like %:search%)" +
        "or (staff.firstName like %:search%)" +
        "or (staff.lastName like %:search%)" +
        " ) "
    )
    Set<Movie> getMoviesSearch(@Param("search") String search);
}
