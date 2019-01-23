package Spring.Repositories;

import Spring.Entities.SongsComments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongsCommentsRepository extends CrudRepository<SongsComments, Integer>, PagingAndSortingRepository<SongsComments, Integer> {
    @Query("SELECT a FROM SongsComments a ORDER BY a.commentsDate DESC")
    Iterable<SongsComments> sortSongsCommentsByDate();
    @Query("SELECT a FROM SongsComments a ORDER BY a.rating DESC")
    Iterable<SongsComments> sortSongsCommentsByRating();
}
