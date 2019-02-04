package Spring.Repositories;

import Spring.Entities.Bands;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BandsRepository  extends CrudRepository<Bands, Integer>, PagingAndSortingRepository<Bands, Integer> {

    Bands findById(int id);

    @Query("select b from Bands b where b.bandName like ?1")
    Iterable<Bands> findByBandName(String albumName);

    @Query("select b from Bands b where b.averageRateOfBand <= ?1")
    Iterable<Bands> findBandsWithLowerOrEqualAverageRate(float averaneRateOfBand);

    @Query("select b from Bands b where b.averageRateOfBand >= ?1")
    Iterable<Bands> findBandsWithHigherOrEqualAverageRate(float averaneRateOfBand);

}
