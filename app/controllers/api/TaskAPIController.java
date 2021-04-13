package controllers.api;

import play.mvc.*;

/**
 * Controllers for APIs for Task CRUD Operations
 *
 */
public class TaskAPIController extends Controller {

    public Result get(int id) {
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

    public Result delete() {
        return ok();
    }

}
