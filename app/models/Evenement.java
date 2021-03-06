package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Elliot on 03/12/2015.
 */
@Entity
@Table(name = "evenement")
public class Evenement extends Model{
    public static final Integer radius = 50;

    @Column
    @Enumerated(EnumType.STRING)
    public Post.TypeCatastrophe type;

    @Column
    public Double lat;

    @Column
    public Double lon;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateCreation;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateFin;

    @JoinColumn
    @OneToMany
    public List<Post> lesPosts;

    public Evenement(Post.TypeCatastrophe type, Double lat, Double lon, List<Post> lesPosts){
        this.type = type;
        this.lat = lat;
        this.lon = lon;
        this.lesPosts = lesPosts;
    }

    public Evenement() {

    }
}
