package Spring.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})

public class Users {


    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;


    @Column(name = "User_Name", unique = true)
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "User_Permission_Group")
    private String userPermissionGroup;

    //Constructors

    public Users() {
    }

    public Users(String userName, String password, String email, String userPermissionGroup) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userPermissionGroup = userPermissionGroup;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPermissionGroup() {
        return userPermissionGroup;
    }

    public void setUserPermissionGroup(String userPermissionGroup) {
        this.userPermissionGroup = userPermissionGroup;
    }

}
