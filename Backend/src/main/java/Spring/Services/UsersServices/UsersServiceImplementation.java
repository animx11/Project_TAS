package Spring.Services.UsersServices;


import Spring.Entities.Users;
import Spring.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImplementation implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users getById(Integer id){
        return usersRepository.findOne(id);
    }

    @Override
    public Users save(Users user){
        return usersRepository.save(user);
    }

    @Override
    public void delete(Integer id){
        usersRepository.delete(id);
    }



    @Override
    public Iterable<Users> getByUserName(String userName){
        return usersRepository.findByUserName(userName);
    }

    @Override
    public String getByUserEmail(String email){
        return usersRepository.findByUserEmail(email);
    }

    @Override
    public Iterable<Users> getByPermissionGroup(String userPermissionGroup){
        return usersRepository.findByPermissionGroup(userPermissionGroup);
    }

    @Override
    public String getPasswordByUserName(String userName){
        return usersRepository.findPasswordByUserName(userName);
    }

    @Override
    public Iterable<Users> listUsers(){
        return usersRepository.findAll();
    }

    @Override
    public Iterable<Users> listAllPages(Integer pages, Integer howManyOn) {
        return usersRepository.findAll(new PageRequest(pages, howManyOn));
    }

    @Override
    public long howManyRows() {
        return usersRepository.count();
    }
}
