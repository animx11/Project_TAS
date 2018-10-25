package Spring.Controllers;


import Spring.Entities.Users;
import Spring.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

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
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> delete(@PathVariable Integer id){
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users_by_userName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getByUserName(@RequestParam("userName") String userName){
        return usersService.getByUserName(userName);
    }

    @RequestMapping(value = "/users_by_userPermissionGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getByUserPermissionGroup(@RequestParam("userPermissionGroup") String userPermissionGroup){
        return usersService.getByPermissionGroup(userPermissionGroup);
    }


}
