package dao;

import models.Task;
import play.db.DB;

import java.sql.Connection;

/**
 * Data Access Object for Task
 */
public class TaskDAO {

    Connection conn = DB.getConnection();       //Connection to Database

    //public

    /***
     * Close Database Connection
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
