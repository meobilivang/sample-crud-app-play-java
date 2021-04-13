package models;

import java.util.HashSet;
import java.util.Set;

public class User {

    int id;
    String fullName;
    String userName;
    protected String password;
    String email;
    String createdAt;

    //Test databases
    private static Set<User> userTestCollection;

    static {
        userTestCollection = new HashSet();
        userTestCollection.add(new User(1, "Phong", "pnguyen4", "12345678", "pnguyen4@conncoll.edu"));
        userTestCollection.add(new User(2, "Duc", "dtran5", "12345678", "dtran5@conncoll.edu"));
    }

    public User() {}

    public User(String fullName, String userName, String password, String email) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(int id, String fullName, String userName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
    }

    public User(int id, String fullName, String userName, String password, String email) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() { return password; }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
