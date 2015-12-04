package controllers;
import models.Evenement;
import models.Post;
import models.Utilisateur;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import services.FileUploader;

/**
 * Created by Elliot on 03/12/2015.
 */
public class Civil extends BaseController {

    public static void index() {
        render();
    }

    public static void dashboard(Boolean demandeSecours, int size, int page) {
        int start = size * page;

        List<Post> lesPosts = Post.find("order by dateCreation DESC").from(start).fetch(size);
        int nbPosts = Post.findAll().size();
        List<Utilisateur.GroupeSanguin> lesGroupes = Arrays.asList(Utilisateur.GroupeSanguin.values());

        List<Evenement> lesEvenements = Evenement.all().fetch();

        render(lesPosts, lesEvenements, demandeSecours, lesGroupes, nbPosts);
    }

    public static void ajouterPost(String post, Double lat, Double lng, String youtubeURL, File media) {

        String tag = null;
        List<String> splitStr = Arrays.asList(post.split("\\s+"));
        for (String s : splitStr) {
            if(s.contains("#")) {
                tag = s;
                break;
            }
        }
        Post p = new Post();
        if(media!=null) {

            FileUploader uploader = new FileUploader();
            String url = uploader.uploadMediaFile(media);
            p.url = url;
        }
        p.text = post;
        p.youtubeURL = youtubeURL;
        p.lat = lat;
        p.lng = lng;
        p.tag = tag;
        p.typePost = Post.TypePost.OK;
        p.dateCreation = new Date();
        p.ip = request.remoteAddress;
        p.save();
        flash.success("Votre post a été pris en compte");
        dashboard(false, 5, 0);
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
        dashboard(demandeSecours, 5, 0);
    }

    public static void ajouterInfosDanger(String nom, String prenom, String tel, String email,
                                          Utilisateur.GroupeSanguin groupesanguin, String sexe, Date dateNaissance) {
        Utilisateur u = new Utilisateur();
        u.nom = nom;
        u.prenom = prenom;
        u.email = email;
        u.groupeSanguin = groupesanguin;
        u.sexe = sexe;
        u.telephone = tel;
        u.dateNaissance = dateNaissance;
        u.ip = request.remoteAddress;
        u.save();
    }

}
