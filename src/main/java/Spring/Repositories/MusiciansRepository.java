package Spring.Repositories;

import Spring.Entities.Musicians;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MusiciansRepository extends CrudRepository<Musicians, Integer>, PagingAndSortingRepository<Musicians, Integer> {


    Musicians findById(int id);

    @Query("select m from Musicians m where m.firstName like ?1")
    Iterable<Musicians> findMusiciansByFirstName(String firstName);

    @Query("select m from Musicians m where m.lastName like ?1")
    Iterable<Musicians> findMusiciansByLastName(String lastName);

    @Query("select m from Musicians m where m.pseudonym like ?1")
    Iterable<Musicians> findMusiciansByPseudonym(String pseudonym);

    @Query("select m from Musicians m where m.band.bandName like ?1")
    Iterable<Musicians> findMusiciansByBandName(String bandName);


}
