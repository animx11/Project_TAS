package Spring.Entities;

import javax.persistence.*;


@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})

public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "User Name")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "E-mail")
    private String email;

    @Column(name = "User Permission Group")
    private String userPermissionGroup;

    //Constructors

    public Users() {
    }

    public Users(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
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
