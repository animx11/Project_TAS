package Spring.Repositories;

import Spring.Entities.BandsComments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BandsCommentsRepository extends CrudRepository<BandsComments, Integer>, PagingAndSortingRepository<BandsComments, Integer> {
}
