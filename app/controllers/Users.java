package controllers;

import play.mvc.Controller;

/**
 * Created by julien on 15/11/15.
 */
public class Users extends Controller {

    public static void updateProfil() {

    }

    public static void updateProfilPost() {

    }

    public static void disconnect() {
        session.clear();
        flash.success("Vous êtes bien déconnecté.");
        Accueil.index();
    }
}
