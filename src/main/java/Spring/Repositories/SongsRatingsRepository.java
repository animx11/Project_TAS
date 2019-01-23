package Spring.Repositories;

import Spring.Entities.SongsRatings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongsRatingsRepository extends CrudRepository<SongsRatings, Integer>, PagingAndSortingRepository<SongsRatings, Integer> {
}
