package ecall.domain;

import ecall.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "dispatches",
    path = "dispatches"
)
public interface DispatchRepository
    extends PagingAndSortingRepository<Dispatch, Long> {}
