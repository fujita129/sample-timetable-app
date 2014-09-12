package models;

import javax.persistence.*;
import play.db.ebean.*;
import play.data.validation.*;

@Entity
public class Koma extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String day;

    @Constraints.Required
    public String num;

    @Constraints.Required
    public String prof;

    public static Finder<Long,Koma> findKoma = new Finder<Long,Koma>(Long.class, Koma.class);

}
