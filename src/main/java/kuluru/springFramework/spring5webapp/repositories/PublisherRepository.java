package kuluru.springFramework.spring5webapp.repositories;

import kuluru.springFramework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
