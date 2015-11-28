package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by julien on 15/11/15.
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends Model {

    // Minimum pour que ça fonctionne
    @Column
    public String email;
    @Column
    public String hashedPassword;

    // Ajouter ce dont on aura besoin
    @Column
    public String nom;

    @Column
    public String prenom;
}
