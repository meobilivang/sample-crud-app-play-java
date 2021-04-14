package controllers;

import dao.TaskDAO;
import models.Task;

import play.mvc.*;

import java.util.List;

/**
 * Controllers for Views of Task
 */
public class TaskController extends Controller {

    /**
     * Get List of Tasks by User
     * @return
     */
    public Result list(int ownerId) {

        try {

            TaskDAO taskDAO = new TaskDAO();
            List<Task> taskList = taskDAO.getTaskListByOwnerId(ownerId);

            return ok(views.html.Task.index.render(taskList));
        } catch(Exception e) {
            e.printStackTrace();
            return internalServerError("Please try again later");
        }

    }

    /**
     *
     */
    public Result create() {

        try {

        } catch(Exception e) {
            e.printStackTrace();
            return internalServerError("Please try again later");
        }

    }

    /**
     *
     * @return
     */
    public Result edit() {

        try {

        } catch(Exception e) {
            e.printStackTrace();
            return internalServerError("Please try again later");
        }
    }

//    /**
//     * Delete Task by id
//     * @param deletedTaskId
//     * @return
//     */
//    public Result delete(int deletedTaskId) {
//        return null;
//    }

}
