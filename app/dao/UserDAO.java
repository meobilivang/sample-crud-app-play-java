package dao;

import models.User;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import play.db.DB;

/**
 * Data Access Layer for User
 */
public class UserDAO {

    Connection connection = DB.getConnection();

    protected String selectSQLStr = "SELECT id, full_name, user_name, email, created_at FROM user";
    protected String whereIDSQLStr = "WHERE id=";

    public List<User> getUserList() {

        List<User> userList = new ArrayList();

        try {
            PreparedStatement ps = connection.prepareStatement(this.selectSQLStr);
            ResultSet resultSet = ps.executeQuery();

            User eachUser;

            int eachId;
            String eachName;
            String eachUserName;
            String eachEmail;
            String createdAt;

            //Iterate returned rows
            while (resultSet.next()) {

                //Retrieve fields from rows
                eachId = resultSet.getInt("id");
                eachName = resultSet.getString("full_name");
                eachUserName = resultSet.getString("user_name");
                eachEmail = resultSet.getString("email");
                createdAt = resultSet.getTime("created_at").toString();

                eachUser = new User(eachId, eachName, eachUserName, eachEmail);
                eachUser.setCreatedAt(createdAt);

                userList.add(eachUser);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public User getUserById(int id) {

        User searchUser = null;
        String sqlStr = selectSQLStr + whereIDSQLStr + id;

        try {

            PreparedStatement ps = connection.prepareStatement(sqlStr);
            ResultSet resultSet = ps.executeQuery();

            searchUser = new User(resultSet.getInt("id"), resultSet.getString("full_name"), resultSet.getString("user_name"), resultSet.getString("email"));
            searchUser.setCreatedAt(resultSet.getTime("created_at").toString());

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return searchUser;
    }

    /**
     * Insert/Create new User to Database
     * @param newUser
     * @return
     */
    public boolean addUser(User newUser) {

        String sqlStr = "INSERT INTO user (full_name, user_name, password, email) VALUES (" + newUser.getName()  + newUser.getUserName() + newUser.getPassword() + ")";

        try {

            PreparedStatement ps = connection.prepareStatement(sqlStr);
            int createdCounter = ps.executeUpdate();

            return createdCounter == 1;

        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update data of an user on Database
     *
     * Fields allowed for modifications:
     *      - Name
     *      - Username
     *      - Email
     *
     * @param editedUser
     * @return
     */
    public boolean editUser(User editedUser) {

        String sqlStr = "UPDATE user SET full_name=" + editedUser.getName() + ", user_name=" + editedUser.getUserName() + ", email=" + editedUser.getEmail()  +" WHERE id=" + String.valueOf(editedUser.getId());

        try {

            PreparedStatement ps = connection.prepareStatement(sqlStr);
            int updatedCounter = ps.executeUpdate();

            return updatedCounter > 0;

        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete an user with given id from Database
     *
     * @param id
     * @return
     */
    public boolean deleteUserById(int id) {

        String sqlStr = "DELETE FROM user WHERE id=" + id;

        try {

            PreparedStatement ps = connection.prepareStatement(sqlStr);
            int deletedCounter = ps.executeUpdate();

            return deletedCounter == 1;

        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
