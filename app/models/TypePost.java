package models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cedricrohaut on 12/3/15.
 */
@Entity
@Table(name = "typepost")
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
