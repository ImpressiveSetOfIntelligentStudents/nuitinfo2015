package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import models.Evenement;
import models.Post;
import models.Utilisateur;
import models.UtilisateurAutorite;
import models.Evenement;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.util.*;

/**
 * Created by steve on 03/12/15.
 */
public class Autorite extends BaseController {

    public static void index() {

        if (getConnectedUser() == null){
            Autorite.connect();
        }

        List<Evenement> events = Evenement.findAll();

        for (Evenement event : events) {
            System.out.println(event.id);
        }

        List<Post> inDangerList = Post.find("typePost = ?", Post.TypePost.DANGER).fetch();

        render(events, inDangerList);

    }

    public static void details(Long idEvent) {

        if (getConnectedUser() == null){
            Autorite.connect();
        }


        Evenement baseEvent = Evenement.findById(idEvent);

        Post basePost = baseEvent.lesPosts.get(0);

        Boolean finEvent = false;
        if (baseEvent.dateFin == null){
            finEvent = false;
        }else{
            finEvent = true;
        }


        render(baseEvent, basePost,finEvent);
    }

    public static void detailsPost(Long idEvent,Boolean finEvent) {

        Evenement baseEvent = Evenement.findById(idEvent);

        if (finEvent){
            baseEvent.dateFin = new Date();
        }else{
            baseEvent.dateFin = null;
        }

        baseEvent.save();

        details(idEvent);


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
