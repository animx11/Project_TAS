package Spring.Repositories;

import Spring.Entities.Songs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongsRepository extends CrudRepository<Songs, Integer>, PagingAndSortingRepository<Songs, Integer> {

    Songs findById(int id);

    @Query("select a from Songs a where a.songsName like ?1")
    Iterable<Songs> findBySongName(String songName);

    @Query("select a from Songs a where a.averangeRateOfSong <= ?1")
    Iterable<Songs> findSongsWithLowerOrEqualAverangeRate(float averangeRateOfSong);

    @Query("select a from Songs a where a.averangeRateOfSong >= ?1")
    Iterable<Songs> findSongsWithHigherOrEqualAverangeRate(float averangeRateOfSong);
}