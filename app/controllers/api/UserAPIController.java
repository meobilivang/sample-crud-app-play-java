package controllers.api;

import controllers.api.response.Response;

import dao.UserDAO;
import models.User;
import play.mvc.*;

import play.libs.Json;

import java.util.List;

/**
 * Controllers for User APIs CRUD Operations
 */
public class UserAPIController extends Controller {

    /**
     * Get User by ID API
     * @param id
     * @return
     */
    public Result get(int id) {
        try {

            UserDAO userDAO = new UserDAO();
            User searchUser = userDAO.getUserById(id);

            userDAO.closeConnection();

            return ok(Json.toJson(searchUser));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * List User API
     * @return
     */
    public Result list() {
        try {

            UserDAO userDAO = new UserDAO();
            List<User> searchUserList = userDAO.getUserList();

            userDAO.closeConnection();

            return ok(Json.toJson(searchUserList));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * Add User API
     * @return
     */
    public Result add() {
        try {

            //Retrieving User object from Request body
            User newUser = Json.fromJson(request().body().asJson(), User.class);

            UserDAO userDAO = new UserDAO();
            boolean isUserAdded = userDAO.addUser(newUser);

            userDAO.closeConnection();

            return isUserAdded
                    ? ok(Json.toJson(new Response("Success", "Add operation successfully executed!")))
                    : badRequest(Json.toJson(new Response("Failed", "Add operation failed!")));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * Edit User API
     *
     * @return
     */
    public Result edit() {
        try {

            //Retrieving User object from Request body
            User editUserObj = Json.fromJson(request().body().asJson(), User.class);

            UserDAO userDAO = new UserDAO();
            boolean isUserEdited = userDAO.editUser(editUserObj);

            userDAO.closeConnection();

            return isUserEdited
                    ? ok(Json.toJson(new Response("Success", "Edit operation successfully executed!")))
                    : badRequest(Json.toJson(new Response("Failed", "Edit operation failed!")));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

    /**
     * Delete User by Id API
     * @param id
     * @return
     */
    public Result delete(int id) {
        try {

            UserDAO userDAO = new UserDAO();
            boolean isUserDeleted = userDAO.deleteUserById(id);

            userDAO.closeConnection();

            return isUserDeleted
                    ? ok(Json.toJson(new Response("Success", "Delete operation successfully executed!")))
                    : badRequest(Json.toJson(new Response("Failed", "Delete operation failed!")));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson(new Response("Internal  Server Error", "Please try again later!")));
        }
    }

}
