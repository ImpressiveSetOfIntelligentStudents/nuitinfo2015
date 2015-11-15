package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by julien on 15/11/15.
 */
@Entity
@Table(name = "user")
public class User extends Model {

    @Column
    public String email;
    @Column
    public String hashedPassword;
    @Column
    public String salt;

    // Ajouter ce dont on aura besoin
}
