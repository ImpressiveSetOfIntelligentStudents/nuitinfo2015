package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by julien on 15/11/15.
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends Model {
    @Column
    public String ip;

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

    @Column
    public String sexe;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateNaissance;

    @Column
    public String telephone;

    public enum GroupeSanguin {
        ONEG("O-"),
        OPOS("O+"),
        ANEG("A-"),
        APOS("A+"),
        BNEG("B-"),
        BPOS("B+"),
        ABNEG("AB-"),
        ABPOS("AB+");

        private String name = "";

        GroupeSanguin(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }
}
