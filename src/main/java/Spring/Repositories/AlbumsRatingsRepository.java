package Spring.Repositories;

import Spring.Entities.AlbumsRatings;
import Spring.Entities.Albums;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumsRatingsRepository extends CrudRepository<AlbumsRatings, Integer>, PagingAndSortingRepository<AlbumsRatings, Integer> {

    @Query("SELECT AVG(a.rating) FROM AlbumsRatings a WHERE a.album LIKE ?1")
    Iterable<AlbumsRatings> averangeRating(Albums album);

}
