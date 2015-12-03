package controllers;

import models.Evenement;

/**
 * Created by Elliot on 03/12/2015.
 */
public class Evenements extends BaseController {

    public static void index(Long id) {
        Evenement ev = Evenement.findById(id);
        render(ev);
    }
}
