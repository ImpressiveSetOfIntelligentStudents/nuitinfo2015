package jobs;

import models.Evenement;
import models.Post;
import models.Utilisateur;
import play.jobs.*;

import java.util.*;

@OnApplicationStart
public class Bootstrap extends Job {

    public void jeuDeTest() {
        Evenement e1 = new Evenement(Post.TypeCatastrophe.ATTENTAT, 0.0, 0.0, new ArrayList<Post>());
        e1.save();
        Evenement e2 = new Evenement(Post.TypeCatastrophe.INONDATION, 40.0, 12.0, new ArrayList<Post>());
        e2.save();
    }

}