package controllers;

/**
 * Created by steve on 03/12/15.
 */
public class DashBoardAuthority extends BaseController {

    public static void index() {
        boolean isAccueil = true;
        render(isAccueil);
    }


    public static void details() {
        boolean isAccueil = true;
        render(isAccueil);
    }
}
