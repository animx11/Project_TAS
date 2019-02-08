package Spring.Repositories;

import Spring.Entities.Bands;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BandsRepository extends CrudRepository<Bands, Integer>, PagingAndSortingRepository<Bands, Integer> {

    Bands findById(int id);

    @Query("select a from Bands a where a.name like ?1")
    Iterable<Bands> findByBandName(String name);

    @Query("SELECT a FROM Bands a ORDER BY a.averangeRateOfBand DESC" )
    Iterable<Bands> sortBandsByRating();

    @Query("select a from Bands a where a.averangeRateOfBand <= ?1")
    Iterable<Bands> findBandsWithLowerOrEqualAverangeRate(float averangeRateOfBand);

    @Query("select a from Bands a where a.averangeRateOfBand >= ?1")
    Iterable<Bands> findBandsWithHigherOrEqualAverangeRate(float averangeRateOfBand);
}