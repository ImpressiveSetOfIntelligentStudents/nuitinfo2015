package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by julien on 15/11/15.
 */
@Entity
@Table(name = "autorite")
public class UtilisateurAutorite extends Model {


    @Column
    public String email;

    @Column
    public String hashedPassword;

    @Column
    public String nom;

    @Column
    public String prenom;



}
