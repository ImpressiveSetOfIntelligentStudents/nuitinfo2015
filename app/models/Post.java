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
    public Location location;

    @Column
    public TypePost typePost;

}
