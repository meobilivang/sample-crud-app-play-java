package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class HomeController extends Controller {

    public Result index () {
        return ok(index.render("Your Project is hereee!"));
    }

    public Result helloWorld () {
        return ok("Hello World");
    }

}
