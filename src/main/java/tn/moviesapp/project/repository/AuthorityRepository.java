package tn.moviesapp.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.moviesapp.project.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
