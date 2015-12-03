package controllers;

import models.Utilisateur;
import models.UtilisateurAutorite;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by steve on 03/12/15.
 */
public class Autorite extends BaseController {

    public static void index() {

        if (getConnectedUser() == null){
            Autorite.connect();
        }

        render();

    }

    public static void details() {
        render();
    }

    public static void connect() {
        render();
    }

    public static void connectPost(String email, String motDePasse) {
        UtilisateurAutorite user = UtilisateurAutorite.find("email = ?", email).first();
        if(user == null) {
            flash.error("Les identifiants sont incorrects.");
            index();
        }

        if(user.hashedPassword.equals(DigestUtils.sha1Hex(motDePasse))) {
            session.put("idUser", user.id);
            flash.success("Vous êtes bien connecté.");
            index();
        } else {
            flash.error("Les identifiants sont incorrects.");
            connect();
        }

    }

    public static void register() {
        render();
    }

    public static void registerPost(String nom, String prenom, String motDePasse, String motDePasseConfirmation, String email) {
        UtilisateurAutorite user = new UtilisateurAutorite();
        user.email = email;
        user.nom = nom;
        user.prenom = prenom;

        if(UtilisateurAutorite.count("email = ?", email) > 0) {
            flash.error("Cette adresse email est déjà associée à un utilisateur.");
            params.flash();
            register();
        }

        if(motDePasse.equals(motDePasseConfirmation)) {
            user.hashedPassword = DigestUtils.sha1Hex(motDePasse);
            user.save();
            flash.success("Votre inscription a bien été prise en compte.");
            index();
        } else {
            flash.error("Les deux mot de passe doivent être équivalent.");
            params.flash();
            register();
        }
    }

    public static void disconnect() {
        session.clear();
        flash.success("Vous êtes bien déconnecté.");
        index();
    }
}
