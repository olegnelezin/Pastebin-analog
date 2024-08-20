package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@NoArgsConstructor
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
}