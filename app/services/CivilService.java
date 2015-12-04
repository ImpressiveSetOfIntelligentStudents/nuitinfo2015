package services;

import models.Evenement;
import models.Post;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by terry on 04/12/2015.
 */
public class CivilService {

    public static boolean isInRadius(Evenement event, Post post) {

        Double x = Math.pow((post.lng - event.lon),2);
        Double y = Math.pow((post.lat - event.lat),2);

        Double r = x + y;

        return r <= Math.pow(event.radius,2);
    }

    public static Evenement createEvent(Post p) {
        Evenement newEvent = new Evenement();
        newEvent.lat = p.lat;
        newEvent.lon = p.lng;
        newEvent.type = Post.TypeCatastrophe.ADEFINIR;
        newEvent.lesPosts = new ArrayList<Post>();
        newEvent.lesPosts.add(p);
        newEvent.dateCreation = new Date();
        newEvent.save();

        return  newEvent;
    }
}
