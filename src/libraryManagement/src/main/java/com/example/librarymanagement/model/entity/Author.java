package com.example.librarymanagement.model.entity;


import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "biography")
    private String biography;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_at")
    private OffsetDateTime created_at = OffsetDateTime.now();
}
