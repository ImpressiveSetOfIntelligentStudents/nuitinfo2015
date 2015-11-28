package controllers;

import models.Utilisateur;
import play.data.binding.As;

import java.io.File;
import java.util.*;

/**
 * Created by julien on 28/11/15.
 */



/*
    Chaque controller doit extends une classe :
    - BaseController si les pages doivent être accessible à tout le monde
    - SecureController si les pages doivent être accesibles aux utilisateurs connectés
 */

public class Tuto extends BaseController {

    /*
        Chaque méthodes du controller représente une action.
        De base, pour appelé une méthode : http://localhost/{nomController}/{nomAction}

        Les paramètres HTTP sont simplement des parametres pour la méthode
     */
    public static void uneAction(String nom, Long id, @As("dd/MM/yyyy") Date date, Boolean vrai, List<String> lesJoueurs) {

        // Trouver une entité en base de données

        Utilisateur utilisateur = Utilisateur.findById(1);
        Utilisateur utilisateur1 = Utilisateur.find("nom = ? AND role.nom = ?", "", "").first();
        // Notez qu'il est possible de faire des requetes sur des valeurs qui sont dans un objet de la classe Utilsiateur dans faire de jointures
        // Par exemple ici, la classe Utilisateur possède un attribut de type Role (avec un is, un nom, etc...)

        List<Utilisateur> lesUtilisateurs = Utilisateur.findAll();
        lesUtilisateurs = Utilisateur.all().fetch(1, 50); // Pour paginer les résultats par exemple
        Long nbUtilisateur = Utilisateur.count();

        // Creer des entité en base de donnée
        Utilisateur utilisateur2 = new Utilisateur();
        utilisateur2.email = "unEmail@test.fr";
        // ...
        utilisateur2.save();

        // Pour modifier, on récupére une entité en BDD, on modifie puis .save()

        // Pour supprimer une entité.
        Long idUtilisateur = 4L;
        Utilisateur.delete("id = ?", idUtilisateur);
        Utilisateur.deleteAll();


        // Pour afficher une vue, on utilise la méthode render. Elle prend en parametre les variables qu'on souhaite afficher dans la vue.
        render(utilisateur);

        // Pour renvoyé un flux Json
        Map<String, Object> map = new HashMap<>();
        map.put("message", "L'utilisateur est sauvegardé !");
        renderJSON(map);

        // Pour renvoyer un fichier
        File f = new File("unFichier");
        renderBinary(f);

        // Pas mal d'autre possiblité, mais on aura sans soute pas a s'en servir


        notFound(); // Pour renvoyer une 404
        notFoundIfNull(null); // Retourne directement une 404 si l'objet en paramètre est null
        forbidden(); // ...
        // ...

        // Pour les redirections
        uneAutreAction();
        // Ou alors un appel a la méthode redirect, qui permet plus de chose
    }

    public static void uneAutreAction() {
        render();
    }

    public static void exempleAJAX(Integer unNombre) {
        Map<String, Object> reponse = new HashMap<>();
        reponse.put("message", new Date()+" : Nombre généré coté controler");
        reponse.put("nombre", unNombre * 3);
        renderJSON(reponse);
    }
}
