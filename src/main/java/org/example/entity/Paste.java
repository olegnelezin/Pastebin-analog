package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paste")
public class Paste {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String minioUrl;

    public Paste(String title, String minioUrl) {
        this.title = title;
        this.minioUrl = minioUrl;
    }

    public Paste() {

    }
}
