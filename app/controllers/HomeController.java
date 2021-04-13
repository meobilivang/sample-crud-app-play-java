package controllers;

import play.*;
import play.data.FormFactory;
import play.mvc.*;

import views.html.index;

import views.html.Home.*;

import javax.inject.Inject;

public class HomeController extends Controller {

    public Result index () {
        return ok("Your Project is hereee!");
    }

    /**
     * Test Route
     * @return
     */
    public Result helloWorld (String name, String userName) {
        return ok(helloWorld.render(name, userName));
    }

}
