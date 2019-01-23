package Spring.Repositories;

import Spring.Entities.AlbumsRatings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumsRatingsRepository extends CrudRepository<AlbumsRatings, Integer>, PagingAndSortingRepository<AlbumsRatings, Integer> {
}
