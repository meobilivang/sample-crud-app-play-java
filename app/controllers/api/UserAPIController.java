package controllers.api;

import dao.UserDAO;
import play.mvc.*;

import play.libs.Json;

/**
 * Controllers for User APIs CRUD Operations
 */
public class UserAPIController extends Controller {

    public Result get(int id) {
        try {
            UserDAO userDAO = new UserDAO();
        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError(Json.toJson());
        } finally {
            userDAO.close();
        }
        return ok("Get");
    }

    public Result list() {
        return ok();
    }

    public Result create() {
        return ok();
    }

    public Result edit() {
        return ok();
    }

    public Result delete(int id) {
        return ok();
    }

}
