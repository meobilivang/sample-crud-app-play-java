package controllers;

import dao.UserDAO;
import models.User;
import play.mvc.*;

import java.util.List;
import java.util.ArrayList;


/***
 * Controllers for Views of User
 *
 */
public class UserController extends Controller {

    /**
     * Get list of users
     * @return
     */
    public Result list() {

        try {

            UserDAO userDAO = new UserDAO();
            List<User> userList = userDAO.getUserList();

            userDAO.closeConnection();

            return ok(views.html.User.index.render(userList));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError("Please try again!");
        }
    }

    /**
     * Create new User
     * @return
     */
    public Result create() {
        return ok(views.html.User.create.render());
    }

    /**
     * Edit User
     * @return
     */
    public Result edit(int id) {
        try {

            UserDAO userDAO = new UserDAO();
            User editUser = userDAO.getUserById(id);

            userDAO.closeConnection();

            return ok(views.html.User.edit.render(editUser));

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError("Please try again!");
        }
    }

//    /**
//     * Delete User
//     * @param deletedUserId
//     * @return
//     */
//    public Result deleteUser(int deletedUserId) {
//        return null;
//    }

}
