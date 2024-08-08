package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String url;

    @OneToOne
    private Paste paste;

    public Record(String url, Paste paste) {
        this.url = url;
        this.paste = paste;
    }

    public Record() {

    }

    public String getUrl() {
        return url;
    }

    public Paste getPaste() {
        return paste;
    }

    public void setPaste(Paste paste) {
        this.paste = paste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}