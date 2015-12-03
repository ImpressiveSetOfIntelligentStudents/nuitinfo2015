package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cedricrohaut on 12/3/15.
 */
@Entity
@Table(name = "location")
public class Location extends Model {
    @Column
    public long lattitude;

    @Column
    public long longitude;

    @Column
    public long altitude;
}
