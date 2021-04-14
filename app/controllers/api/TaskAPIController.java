package controllers.api;

import controllers.api.response.Response;
import dao.TaskDAO;
import models.Task;
import play.mvc.*;

import play.libs.Json;

import java.util.List;

/**
 * Controllers for APIs for Task CRUD Operations
 *
 */
public class TaskAPIController extends Controller {

    /**
     * Get Task by ID API
     * @param id
     * @return
     */
    public Result get(int id) {
        try {

            TaskDAO taskDAO = new TaskDAO();
            Task searchTask = taskDAO.getTaskById(id);

            taskDAO.closeConnection();

            return ok(Json.toJson(searchTask));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * List Task API
     * @return
     */
    public Result list() {
        try {

            TaskDAO taskDAO = new TaskDAO();
            List<Task> searchTaskList = taskDAO.getTaskList();

            taskDAO.closeConnection();

            return ok(Json.toJson(searchTaskList));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * Add Task API
     * @return
     */
    public Result add() {
        try {

            //Retrieving Task object from Request body
            Task newTask = Json.fromJson(request().body().asJson(), Task.class);

            TaskDAO taskDAO = new TaskDAO();
            boolean isTaskAdded = taskDAO.addTask(newTask);

            taskDAO.closeConnection();

            return isTaskAdded
                    ? ok(Json.toJson(new Response("Success", "Add operation successfully executed!")))
                    : badRequest(Json.toJson(new Response("Failed", "Add operation failed!")));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * Edit Task API
     *
     * @return
     */
    public Result edit() {
        try {

            //Retrieving Task object from Request body
            Task editTaskObj = Json.fromJson(request().body().asJson(), Task.class);

            TaskDAO taskDAO = new TaskDAO();
            boolean isTaskEdited = taskDAO.editTask(editTaskObj);

            taskDAO.closeConnection();

            return isTaskEdited
                    ? ok(Json.toJson(new Response("Success", "Edit operation successfully executed!")))
                    : badRequest(Json.toJson(new Response("Failed", "Edit operation failed!")));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * Delete Task by Id API
     * @param id
     * @return
     */
    public Result delete(int id) {
        try {

            TaskDAO taskDAO = new TaskDAO();
            boolean isTaskDeleted = taskDAO.deleteTaskById(id);

            taskDAO.closeConnection();

            return isTaskDeleted
                    ? ok(Json.toJson(new Response("Success", "Delete operation successfully executed!")))
                    : badRequest(Json.toJson(new Response("Failed", "Delete operation failed!")));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

}
