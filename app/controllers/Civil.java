package controllers;
import models.Post;
import models.Utilisateur;

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
        List<Utilisateur.GroupeSanguin> lesGroupes = Arrays.asList(Utilisateur.GroupeSanguin.values());
        render(lesPosts, demandeSecours, lesGroupes);
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
        p.ip = request.remoteAddress;
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
        p.ip = request.remoteAddress;
        p.save();

        flash.success("Votre demande de secours a bien été prise en compte");
        boolean demandeSecours = true;
        dashboard(demandeSecours);
    }

    public static void ajouterInfosDanger(String nom, String prenom, String tel, String email, Utilisateur.GroupeSanguin groupesanguin, String sexe) {
        Utilisateur u = new Utilisateur();
        u.nom = nom;
        u.prenom = prenom;
        u.email = email;
        u.groupeSanguin = groupesanguin;
        u.sexe = sexe;
        u.telephone = tel;
        //u.dateNaissance = dateNaissance;

        u.save();
    }

}
