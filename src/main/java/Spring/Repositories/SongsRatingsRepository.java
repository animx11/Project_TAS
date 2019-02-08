package Spring.Repositories;

import Spring.Entities.SongsRatings;
import Spring.Entities.Songs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongsRatingsRepository extends CrudRepository<SongsRatings, Integer>, PagingAndSortingRepository<SongsRatings, Integer> {
    @Query("SELECT AVG(a.rating) FROM SongsRatings a WHERE a.song LIKE ?1")
    Iterable<SongsRatings> averangeRating(Songs song);

}
