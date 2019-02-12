package Spring.Controllers;


import Spring.Cipher.EncrypterAES;
import Spring.Entities.Users;
import Spring.Services.UsersServices.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UsersService usersService;

    private EncrypterAES encrypterAES = new EncrypterAES();

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> listUsers(){
        return usersService.listUsers();
    }

    @RequestMapping(value = "/users_by_id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users getByParamPublicId(@RequestParam("id") Integer id){
        return usersService.getById(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users getByPublicId(@PathVariable("id") Integer id){
        return usersService.getById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Users> create(@RequestBody @Valid @NotNull Users user){

            String passwordToEncrypt = user.getPassword();
            char email[] = user.getEmail().toCharArray();
            boolean isAtInEmail = false;
            boolean isDomainCorrect = false;

            for(int i = 0; i < email.length; i++){
                if(!isAtInEmail) {
                    if (email[i] == '@') {
                        isAtInEmail = true;
                    }
                }
                else{
                    if(!isDomainCorrect){
                        if(email[i] == '.'){
                            if(email.length - i > 4){
                                i = email.length;
                            }
                            else{
                                isDomainCorrect = true;
                                i = email.length;
                            }
                        }
                    }
                }
            }

            if(!isAtInEmail || !isDomainCorrect) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if(usersService.getByUserEmail(user.getEmail()) != null ){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

            user.setPassword(encrypterAES.encrypt(passwordToEncrypt));

            usersService.save(user);

            return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<Users> edit(@RequestBody @Valid @NotNull Users user){
        Users editUser = usersService.getById((user.getId()));
        if(Objects.nonNull(editUser)){
            usersService.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/users`", method = RequestMethod.DELETE)
    public ResponseEntity<Users> delete(@RequestParam("id") Integer id){
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users_by_userName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getByUserName(@RequestParam("userName") String userName){
        return usersService.getByUserName(userName);
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public boolean login(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword){

        userPassword = encrypterAES.encrypt(userPassword);

        if(userPassword.equals(usersService.getPasswordByUserName(userName))){
            return true;
        }
        else{
            return false;
        }

    }

    @RequestMapping(value = "/users_by_userPermissionGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getByUserPermissionGroup(@RequestParam("userPermissionGroup") String userPermissionGroup){
        return usersService.getByPermissionGroup(userPermissionGroup);
    }

}
