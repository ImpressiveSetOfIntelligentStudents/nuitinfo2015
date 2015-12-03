package controllers;
import models.Post;

import java.util.Date;
import java.util.List;

/**
 * Created by Elliot on 03/12/2015.
 */
public class Civil extends BaseController {

    public static void index() {
        render();
    }

    public static void dashboard(Boolean demandeSecours) {
        List<Post> lesPosts = Post.all().fetch();
        render(lesPosts, demandeSecours);
    }

    public static void ajouterPost(String post, Double lat, Double lng) {
        Post p = new Post();
        p.text = post;
        p.lat = lat;
        p.lng = lng;
        p.typePost = Post.TypePost.OK;
        p.dateCreation = new Date();
        p.save();
        flash.success("Votre post a été pris en compte");
        dashboard(false);
    }


    public static void ajouterPostDanger(Double lat, Double lng) {
        Post p = new Post();
        p.dateCreation = new Date();
        p.lng = lng;
        p.lat = lat;
        p.typePost = Post.TypePost.DANGER;
        p.save();

        flash.success("Votre demande de secours a bien été prise en compte");
        boolean demandeSecours = true;
        dashboard(demandeSecours);
    }

}
