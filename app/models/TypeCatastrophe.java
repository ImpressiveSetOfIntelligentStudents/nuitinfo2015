package models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cedricrohaut on 12/3/15.
 */
@Entity
@Table(name = "typecatastrophe")
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
