package dao;

import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import play.db.DB;

import java.sql.Connection;
import java.sql.SQLDataException;

/**
 * Data Access Layer for User
 */
public class UserDAO {

    Connection connection = DB.getConnection();
    String 

    public List<User> getUserList() {

        String sqlStr = "SELECT id, full_name, user_name, email, created_at FROM user";
        List<User> userList = new ArrayList();

        try {
            PreparedStatement ps = connection.prepareStatement(sqlStr);
            ResultSet resultSet = ps.executeQuery(ps);

            while (resultSet.next()) {

            }

        } catch(SQLDataException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public List<User> getUserById() {

        String sqlStr = "SELECT id, full_name, user_name, email, created_at FROM user";
        List<User> userList = new ArrayList();

        try {
            PreparedStatement ps = connection.prepareStatement(sqlStr);
            ResultSet resultSet = ps.executeQuery(ps);

            while (resultSet.next()) {

            }

        } catch(SQLDataException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
