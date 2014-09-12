package controllers;

import java.util.List;

import play.mvc.*;
import play.data.*;
import play.db.ebean.Model.Finder;
import static play.data.Form.*;
import views.html.*;
import models.*;

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

    /**
     * Display the 'new koma form'.
     */
    public static Result createKoma() {
        Form<Koma> komaForm = form(Koma.class);
        return ok(
            createKomaForm.render(komaForm)
        );
    }

    /**
     * Handle the 'new koma form' submission
     */
    public static Result saveKoma() {
        Form<Koma> komaForm = form(Koma.class).bindFromRequest();
        if(komaForm.hasErrors()) {
            return badRequest(createKomaForm.render(komaForm));
        }
        komaForm.get().save();
        flash("success", "Koma " + komaForm.get().name + " has been created");
        return GO_HOME;
    }

    /**
     * @param id Id of the koma to edit
     */
    public static Result updateKoma(Long id) {
        Form<Koma> komaForm = form(Koma.class).bindFromRequest();
        if(komaForm.hasErrors()) {
            return badRequest(editKomaForm.render(id, komaForm));
        }
        komaForm.get().update(id);
        flash("success", "Koma " + komaForm.get().name + " has been updated");
        return GO_HOME;
    }

    /**
     * Display the 'edit form' of a existing Computer.
     *
     * @param id Id of the computer to edit
     */
    public static Result editKoma(Long id) {
        Form<Koma> komaForm = form(Koma.class).fill(
            Koma.findKoma.byId(id)
        );
        return ok(
            editKomaForm.render(id, komaForm)
        );
    }

    /**
     * Handle computer deletion
     */
    public static Result deleteKoma(Long id) {
        Koma.findKoma.ref(id).delete();
        flash("success", "Koma has been deleted");
        return GO_HOME;
    }

}
