package greendata.repositories;

import greendata.domain.client.Investor;
import org.springframework.data.repository.CrudRepository;

public interface InvestorRepository extends CrudRepository<Investor, Long> {
}
