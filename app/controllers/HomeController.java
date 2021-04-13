package controllers;

import play.*;
import play.data.FormFactory;
import play.mvc.*;

import views.html.index;

import views.html.Home.*;

public class HomeController extends Controller {

    public Result index () {
        return ok(views.html.index.render());
    }

    /**
     * Test Route
     * @return
     */
    public Result helloWorld (String name, String userName) {
        return ok(helloWorld.render(name, userName));
    }

}
