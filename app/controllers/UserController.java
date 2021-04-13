package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

/***
 *
 *
 */
public class UserController extends Controller {

    @Inject
    FormFactory formFactory;

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
        Form<User> userForm = formFactory.form(User.class);
        return ok(createUser.render(userForm));
    }

    public Result saveUser() {

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
