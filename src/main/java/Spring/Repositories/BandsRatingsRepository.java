package Spring.Repositories;

import Spring.Entities.BandsRatings;
import Spring.Entities.Bands;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BandsRatingsRepository extends CrudRepository<BandsRatings, Integer>, PagingAndSortingRepository<BandsRatings, Integer> {

    @Query("SELECT AVG(a.rating) FROM BandsRatings a WHERE a.band LIKE ?1")
    Iterable<BandsRatings> averangeRating(Bands band);
}
