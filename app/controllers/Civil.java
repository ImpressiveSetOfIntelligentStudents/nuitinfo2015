package controllers;
import models.Evenement;
import models.Post;

import java.util.ArrayList;
import java.util.Arrays;
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

        /*Evenement e1 = new Evenement(Post.TypeCatastrophe.ATTENTAT, 0.0, 0.0, new ArrayList<Post>());
        e1.save();
        Evenement e2 = new Evenement(Post.TypeCatastrophe.INONDATION, 40.0, 12.0, new ArrayList<Post>());
        e2.save();*/

        List<Evenement> lesEvenements = Evenement.all().fetch();

        System.out.print(lesEvenements.get(1).toString());

        render(lesPosts, lesEvenements, demandeSecours);
    }

    public static void ajouterPost(String post, Double lat, Double lng) {

        String tag = null;
        List<String> splitStr = Arrays.asList(post.split("\\s+"));
        for (String s : splitStr) {
            if(s.contains("#")) {
                tag = s;
                break;
            }
        }

        Post p = new Post();
        p.text = post;
        p.lat = lat;
        p.lng = lng;
        p.tag = tag;
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
