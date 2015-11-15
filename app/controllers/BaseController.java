package controllers;

import play.Play;
import play.mvc.Before;
import play.mvc.Controller;

/**
 * Created by julien on 15/11/15.
 */
public class BaseController extends Controller {

    @Before
    public static void setInfosFromConf() {
        renderArgs.put("title", Play.configuration.getProperty("application.title"));
        renderArgs.put("applicationName", Play.configuration.getProperty("application.nameOnApp"));
    }
}
