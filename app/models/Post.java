package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by cedricrohaut on 12/3/15.
 */
@Entity
@Table(name = "post")
public class Post extends Model {
    @Column
    public String text;

    @Column
    public String youtubeURL;

    @Column
    public String tag;

    @Column
    public String url;

    @Column
    public Double lat;

    @Column
    public Double lng;

    @Column
    public TypePost typePost;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateCreation;

    @Column
    public String ip;


    public enum TypePost {
        DANGER ("Danger"),
        OK ("Ok");

        private String name = "";

        TypePost(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }

    public enum TypeCatastrophe {
        SEISME("Séisme"),
        TSUNAMI ("Tsunami"),
        INONDATION("Inondation"),
        OURAGAN("Ouragan/Cyclone/Typhon"),
        ATTENTAT("Attentat terroriste"),
        BANDITISME("Banditisme"),
        ADEFINIR("INCONNU");

        private String name = "";

        TypeCatastrophe(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }



}
