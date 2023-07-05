package tn.moviesapp.project.service.extended;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.moviesapp.project.repository.extended.CategoryRepositoryExtended;
import tn.moviesapp.project.repository.extended.StaffRepositoryExtended;
import tn.moviesapp.project.service.CategoryService;
import tn.moviesapp.project.service.StaffService;

@Service
@Transactional
public class CategoryServiceExtended extends CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryServiceExtended.class);

    private final CategoryRepositoryExtended categoryRepositoryExtended;
    private final CategoryService categoryService;

    public CategoryServiceExtended(CategoryRepositoryExtended categoryRepositoryExtended, CategoryService categoryService) {
        super(categoryRepositoryExtended);
        this.categoryRepositoryExtended = categoryRepositoryExtended;
        this.categoryService = categoryService;
    }
}
