package ecall.infra;

import ecall.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "centers", path = "centers")
public interface CenterRepository
    extends PagingAndSortingRepository<Center, Long> {
    List<Center> findByCarId(String carId);
}
