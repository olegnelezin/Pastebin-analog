package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

    @Id
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
}