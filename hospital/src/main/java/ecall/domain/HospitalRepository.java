package ecall.domain;

import ecall.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "hospitals", path = "hospitals")
public interface HospitalRepository
    extends PagingAndSortingRepository<Hospital, Long> {}
