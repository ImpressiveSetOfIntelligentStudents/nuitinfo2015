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

    public static void dashboard(int size, int page) {

        int start = size * page;

        List<Post> lesPosts = Post.all().from(start).fetch(size);
        int nbPosts = Post.findAll().size();
        render(lesPosts, nbPosts);
    }

    public static void ajouterPost(String post, Double lat, Double lng) {
        Post p = new Post();
        p.text = post;
        p.lat = lat;
        p.lng = lng;
        p.typePost = Post.TypePost.OK;
        p.save();
        flash.success("Votre post a été pris en compte");
        dashboard(5, 0);
    }


    public static void ajouterPostDanger() {
        dashboard(5, 0);
    }

}
