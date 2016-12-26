package es.dmunozfer.cloud.notes.server.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by David Muñoz on 26/12/2016.
 */
@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    Note() { // JPA
    }

    public Note(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
