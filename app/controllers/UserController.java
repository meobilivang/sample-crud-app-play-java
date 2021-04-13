package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

/***
 * Controllers for Views of User
 *
 */
public class UserController extends Controller {

    @Inject
    FormFactory formFactory;

//    /**
//     * Get an User by Id
//     * @param id
//     * @return
//     */
//    public Result get(int id) {
//        return ok();
//    }

    /**
     * Get list of users
     * @return
     */
    public Result list() {
        return null;
    }

    /**
     * Create new User
     * @return
     */
    public Result create() {
        return null;
    }

    /**
     * Edit User
     * @return
     */
    public Result edit() {
        return null;
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
