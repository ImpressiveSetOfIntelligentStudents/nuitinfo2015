package controllers;

import models.Utilisateur;
import play.mvc.Before;

/**
 * Created by julien on 15/11/15.
 */
public class SecureController extends BaseController{

    @Before
    public static void checkConnexion() {
        Long idUser = Long.getLong(session.get("idUser"));
        if(idUser == null) {
            forbidden();
        } else {
            Utilisateur user = Utilisateur.findById(idUser);
            if(user == null) {
                forbidden();
            } else {
                renderArgs.put("user", user);
            }
        }
    }
}
