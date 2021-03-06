package Spring.Services.UsersServices;

import Spring.Entities.Users;

public interface UsersService {

    Users getById(Integer id);
    Users save(Users user);
    void delete(Integer id);

    Iterable<Users> getByUserName(String userName);
    Iterable<Users> getByPermissionGroup(String userPermissionGroup);
    String getByUserEmail(String email);
    String getPasswordByUserName(String userName);

    Iterable<Users> listUsers();
    Iterable<Users> listAllPages(Integer pages, Integer howManyOn);
    long howManyRows();
}
