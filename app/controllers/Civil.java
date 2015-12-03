package controllers;
import models.Post;

import java.util.List;

/**
 * Created by Elliot on 03/12/2015.
 */
public class Civil extends BaseController {

    public static void index() {
        render();
    }

    public static void dashboard() {
        List<Post> lesPosts = Post.all().fetch();
        render(lesPosts);
    }

    public static void ajouterPost(String post, Double lat, Double lng) {
        Post p = new Post();
        p.text = post;
        p.lat = lat;
        p.lng = lng;
        p.typePost = Post.TypePost.OK;
        p.save();
        flash.success("Votre post a été pris en compte");
        dashboard();
    }


    public static void ajouterPostDanger() {
        dashboard();
    }

}
