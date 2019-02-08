package Spring.Repositories;

import Spring.Entities.Albums;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumsRepository extends CrudRepository<Albums, Integer>, PagingAndSortingRepository<Albums, Integer> {

    Albums findById(int id);

    @Query("SELECT a FROM Albums a WHERE a.albumName LIKE ?1")
    Iterable<Albums> findByAlbumName(String albumName);

    @Query("SELECT a FROM Albums a ORDER BY a.averangeRateOfAlbum DESC")
    Iterable<Albums> sortAlbumsByRating();

    @Query("SELECT a FROM Albums a WHERE a.averangeRateOfAlbum <= ?1")
    Iterable<Albums> findAlbumsWithLowerOrEqualAverangeRate(float averangeRateOfAlbum);

    @Query("SELECT a FROM Albums a WHERE a.averangeRateOfAlbum >= ?1")
    Iterable<Albums> findAlbumsWithHigherOrEqualAverangeRate(float averangeRateOfAlbum);
}
