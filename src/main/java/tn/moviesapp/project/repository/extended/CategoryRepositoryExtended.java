package tn.moviesapp.project.repository.extended;

import org.springframework.stereotype.Repository;
import tn.moviesapp.project.domain.Category;
import tn.moviesapp.project.repository.CategoryRepository;

@Repository
public interface CategoryRepositoryExtended extends CategoryRepository {
    Category findByName(String name);
}
