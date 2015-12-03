package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;

/**
 * Created by cedricrohaut on 12/3/15.
 */
@Entity
@Table(name = "post")
public class Post extends Model {
    @Column
    public String text;

    @Column
    public File media;

    @Column
    public String tag;

    @Column
    public Double lat;

    @Column
    public Double lng;

    @Column
    public TypePost typePost;


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
        BANDITISME("Banditisme");

        private String name = "";

        TypeCatastrophe(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }

}
