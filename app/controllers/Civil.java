package controllers;
import models.Evenement;
import models.Post;
import models.Utilisateur;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import services.CivilService;
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

        List<Post> lesPosts = Post.find("typePost != ? order by dateCreation DESC", Post.TypePost.DANGER).from(start).fetch(size);
        int nbPosts = Post.findAll().size();
        List<Utilisateur.GroupeSanguin> lesGroupes = Arrays.asList(Utilisateur.GroupeSanguin.values());

        List<Evenement> lesEvenements = Evenement.all().fetch();

        render(lesPosts, lesEvenements, demandeSecours, lesGroupes, nbPosts);
    }

    public static void ajouterPost(String post, Double lat, Double lng, String youtubeURL, File media) {

        if(lat == null || lng == null) {
            dashboard(false, 5, 0);
        }

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

        List<Evenement> events = Evenement.findAll();

        if(events.size() == 0) {
            CivilService.createEvent(p);
        } else {
            for (Evenement event : events) {
                if(CivilService.isInRadius(event, p)) {
                    event.lesPosts.add(p);
                    event.save();
                } else {
                    CivilService.createEvent(p);
                    break;
                }
            }
        }

        events = Evenement.findAll();
        System.out.println("**************************************");
        System.out.println(Evenement.findAll().size());
        System.out.println(events.get(0).lesPosts.size());
        dashboard(false, 5, 0);
    }


    public static void ajouterPostDanger(Double lat, Double lng) {
        System.out.println(lat);
        System.out.println(lng);
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
                                          Utilisateur.GroupeSanguin groupesanguin, String sexe, String dateNaissance) {
        Utilisateur u = new Utilisateur();
        u.nom = nom;
        u.prenom = prenom;
        u.email = email;
        u.groupeSanguin = groupesanguin;
        u.sexe = sexe;
        u.telephone = tel;
        u.dateNaissance = new Date();
        u.ip = request.remoteAddress;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            u.dateNaissance = formatter.parse(dateNaissance);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        u.save();

        flash.success("Merci " + u.prenom + " " + u.nom + " (" + u.sexe + ") ! " +
                "Vos informations ont bien été enregistrées. " +
                "Les secours sont prévenus nous allons traiter votre alerte dans les plus brefs délais. " +
                "Résumé de vos informations : En cas de transfusion sanguine nous vous fournirons du sang " +
                u.groupeSanguin.nom() + " ; téléphone : " + u.telephone + " ; date de naissance : "
                + formatter.format(u.dateNaissance) + " ; email : " + u.email + " ; ip : " + u.ip);
        dashboard(false, 5, 0);
    }
}
