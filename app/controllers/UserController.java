package controllers;

import play.mvc.*;

/***
 *
 *
 */
public class UserController extends Controller {

    /**
     * Get an User by Id
     * @param id
     * @return
     */
    public Result getUserById(int id) {
        return ok("User with ID: " + id);
    }

    /**
     * Get list of users
     * @return
     */
    public Result getUserList() {
        return null;
    }

    /**
     * Create new User
     * @return
     */
    public Result createUser() {
        return null;
    }

    /**
     * Edit User
     * @return
     */
    public Result updateUser() {
        return null;
    }

    /**
     * Delete User
     * @param deletedUserId
     * @return
     */
    public Result deleteUser(int deletedUserId) {
        return null;
    }

}
