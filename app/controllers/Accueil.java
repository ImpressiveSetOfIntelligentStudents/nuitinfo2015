package controllers;
import org.apache.commons.codec.digest.DigestUtils;
<<<<<<< HEAD
import java.io.File;
import models.*;
import services.*;
=======
import models.*;
import services.FileUploader;
import java.io.File;
import java.net.*;
>>>>>>> 00261a6a507e29227861446b2d46df350613f5c9

public class Accueil extends BaseController {

    public static void index() {
        boolean isAccueil = true;
        render(isAccueil);
    }

    public static void connect() {
        render();
    }

    public static void connectPost(String email, String motDePasse) {
        Utilisateur user = Utilisateur.find("email = ?", email).first();
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
        Utilisateur user = new Utilisateur();
        user.email = email;
        user.nom = nom;
        user.prenom = prenom;

        if (Utilisateur.count("email = ?", email) > 0) {
            flash.error("Cette adresse email est déjà associée à un utilisateur.");
            params.flash();
            register();
        }

        if (motDePasse.equals(motDePasseConfirmation)) {
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

<<<<<<< HEAD
=======
    public static void upload(File media){
        System.out.println(media.getName());
        FileUploader uploader = new FileUploader();
        String url = uploader.uploadMediaFile(media);
        flash.success(url);
        index();
    }
>>>>>>> 00261a6a507e29227861446b2d46df350613f5c9
}