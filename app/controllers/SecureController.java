package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;

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
            User user = User.findById(idUser);
            if(user == null) {
                forbidden();
            } else {
                renderArgs.put("user", user);
            }
        }
    }
}
