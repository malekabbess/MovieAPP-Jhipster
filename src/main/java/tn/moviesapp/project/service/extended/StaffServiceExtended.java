package tn.moviesapp.project.service.extended;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.moviesapp.project.repository.extended.MovieRepositoryExtended;
import tn.moviesapp.project.repository.extended.StaffRepositoryExtended;
import tn.moviesapp.project.service.StaffService;

@Service
@Transactional
public class StaffServiceExtended extends StaffService {

    private final Logger log = LoggerFactory.getLogger(StaffServiceExtended.class);

    private final StaffRepositoryExtended staffRepositoryExtended;
    private final StaffService staffService;

    public StaffServiceExtended(StaffRepositoryExtended staffRepositoryExtended, StaffService staffService) {
        super(staffRepositoryExtended);
        this.staffRepositoryExtended = staffRepositoryExtended;
        this.staffService = staffService;
    }
}
