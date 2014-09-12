package controllers;

import java.util.List;

import models.Koma;
import play.*;
import play.db.ebean.Model.Finder;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    /**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Application.renderListKoma()
    );

    public static Result index() {
        return GO_HOME;
    }

    /**
     * Display the paginated list of computers.
     */
    public static Result renderListKoma() {
    	Finder<Long, Koma> finder = new Finder<Long, Koma>(Long.class, Koma.class);
    	List<Koma> komas = finder.all();
    	return ok(
    			listKoma.render(komas)
    	);
    }

}
