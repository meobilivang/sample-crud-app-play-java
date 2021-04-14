package dao;

import models.Task;
import play.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Task
 */
public class TaskDAO {

    Connection connection = DB.getConnection();                                 //Connection to database

    protected String selectSQLStr = "SELECT id, owner_id, description, created_at FROM task";
    protected String whereIDSQLStr = " WHERE id=";
    protected String whereOwnerIDSQLStr = " WHERE owner_id=";

    public List<Task> getTaskList() {

        List<Task> taskList = new ArrayList();

        try {

            PreparedStatement ps = connection.prepareStatement(this.selectSQLStr);
            ResultSet resultSet = ps.executeQuery();

            Task eachTask;

            int eachId;
            int ownerId;
            String description;
            String createdAt;

            //Iterate returned rows
            while (resultSet.next()) {

                //Retrieve fields from rows
                eachId = resultSet.getInt("id");
                ownerId = resultSet.getInt("owner_id");
                description = resultSet.getString("description");
                createdAt = resultSet.getTime("created_at").toString();

                eachTask = new Task(eachId, ownerId, description);
                eachTask.setCreatedAt(createdAt);

                taskList.add(eachTask);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return taskList;
    }

    public Task getTaskById(int id) {

        Task searchTask = null;
        String sqlStr = selectSQLStr + whereIDSQLStr + id;

        try {

            PreparedStatement ps = connection.prepareStatement(sqlStr);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                searchTask = new Task(resultSet.getInt("id"), resultSet.getInt("owner_id"), resultSet.getString("description"));
                searchTask.setCreatedAt(resultSet.getTime("created_at").toString());
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return searchTask;
    }

    public Task getTaskByOwnerId(int ownerId) {

        Task searchTask = null;
        String sqlStr = selectSQLStr + whereOwnerIDSQLStr + ownerId;

        try {

            PreparedStatement ps = connection.prepareStatement(sqlStr);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                searchTask = new Task(resultSet.getInt("id"), resultSet.getInt("owner_id"), resultSet.getString("description"));
                searchTask.setCreatedAt(resultSet.getTime("created_at").toString());
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return searchTask;
    }

    /**
     * Insert/Create new Task to Database
     *
     * @param newTask
     * @return
     */
    public boolean addTask(Task newTask) {

        String sqlStr = "INSERT INTO task (owner_id, description) VALUES (" + newTask.getOwnerId()  + ", " + "'" + newTask.getDescription() + "'" + ")";

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
     * Update data of an task on Database
     *
     * Fields allowed for modifications:
     *      - description
     *
     * @param editedTask
     * @return
     */
    public boolean editTask(Task editedTask) {

        String sqlStr = "UPDATE task SET description=" + "'" + editedTask.getDescription() + "'" +" WHERE id=" + String.valueOf(editedTask.getId());

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
     * Delete an task with given id from Database
     *
     * @param id
     * @return
     */
    public boolean deleteTaskById(int id) {

        String sqlStr = "DELETE FROM task WHERE id=" + id;

        try {

            PreparedStatement ps = connection.prepareStatement(sqlStr);
            int deletedCounter = ps.executeUpdate();

            return deletedCounter == 1;

        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /***
     * Close Database Connection
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
