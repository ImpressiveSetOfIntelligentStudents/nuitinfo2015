package controllers;

import org.apache.commons.codec.digest.DigestUtils;
import play.*;
import play.data.validation.Validation;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends BaseController {

    public static void index() {
        boolean isAccueil = true;
        render(isAccueil);
    }

    public static void connect() {
        render();
    }

    public static void connectPost(String email, String motDePasse) {
        User user = User.find("email = ?", email).first();
        if(user == null) {
            flash.error("Les identifiants sont incorrects 1");
            index();
        }

        if(user.hashedPassword.equals(DigestUtils.sha1Hex(motDePasse))) {
            session.put("idUser", user.id);
            flash.success("Vous êtes bien connecté.");
            index();
        } else {
            flash.error("Les identifiants sont incorrects 2");
            connect();
        }

    }

    public static void register() {
        render();
    }

    public static void registerPost(String nom, String prenom, String motDePasse, String motDePasseConfirmation, String email) {
        User user = new User();
        user.email = email;
        user.nom = nom;
        user.prenom = prenom;

        if(User.count("email = ?", email) > 0) {
            flash.error("Cette adresse email est déjà associée à un utilisateur.");
            register();
        }

        if(motDePasse.equals(motDePasseConfirmation)) {
            user.hashedPassword = DigestUtils.sha1Hex(motDePasse);
            user.save();
            flash.success("Votre inscription a bien été prise en compte.");
            index();
        } else {
            flash.error("Les deux mot de passe doivent être équivalent.");
            register();
        }
    }
}