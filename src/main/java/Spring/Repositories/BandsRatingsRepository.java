package Spring.Repositories;

import Spring.Entities.BandsRatings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BandsRatingsRepository extends CrudRepository<BandsRatings, Integer>, PagingAndSortingRepository<BandsRatings, Integer> {
}
