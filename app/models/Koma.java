package models;

import javax.persistence.*;
import play.db.ebean.*;
import play.data.validation.*;

@Entity
public class Koma extends Model {
    private static final long serialVersionUID = 1L;

    public Long id;

    public String name;

    public static Finder<Long,Koma> findKoma = new Finder<Long,Koma>(Long.class, Koma.class);

}
