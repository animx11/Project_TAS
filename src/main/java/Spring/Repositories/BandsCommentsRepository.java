package Spring.Repositories;

import Spring.Entities.BandsComments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BandsCommentsRepository extends CrudRepository<BandsComments, Integer>, PagingAndSortingRepository<BandsComments, Integer> {
    @Query("SELECT a FROM BandsComments a ORDER BY a.commentsDate DESC")
    Iterable<BandsComments> sortBandsCommentsByDate();
    @Query("SELECT a FROM BandsComments a ORDER BY a.rating DESC")
    Iterable<BandsComments> sortBandsCommentsByRating();
}
