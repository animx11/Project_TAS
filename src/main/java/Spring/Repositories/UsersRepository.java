package Spring.Repositories;

import Spring.Entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepository extends CrudRepository<Users, Integer>, PagingAndSortingRepository<Users, Integer> {


    Users findById(int id);

    @Query("select u from Users u where u.userName like ?1")
    Iterable<Users> findByUserName(String userName);

    @Query("select u from Users u where u.userPermissionGroup like ?1")
    Iterable<Users> findByPermissionGroup(String userPermissionGroup);



}
