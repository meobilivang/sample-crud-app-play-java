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
        return ok(views.html.Task.create.render());
    }

    /**
     *
     * @return
     */
    public Result edit(int id) {

        try {

            TaskDAO taskDAO = new TaskDAO();
            Task editTask = taskDAO.getTaskById(id);

            taskDAO.closeConnection();

            return ok(views.html.Task.edit.render(editTask));

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
