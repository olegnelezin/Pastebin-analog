package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

    @Id
    private Long id;

    @Column
    private String url;

    @Column
    private String minioUrl;
}