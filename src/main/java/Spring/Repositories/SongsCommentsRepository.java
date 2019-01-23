package Spring.Repositories;

import Spring.Entities.SongsComments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongsCommentsRepository extends CrudRepository<SongsComments, Integer>, PagingAndSortingRepository<SongsComments, Integer> {
}
