package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "paste")
public class Paste {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String minioUrl;

    public Paste(String title, String minioUrl) {
        this.title = title;
        this.minioUrl = minioUrl;
    }
}
