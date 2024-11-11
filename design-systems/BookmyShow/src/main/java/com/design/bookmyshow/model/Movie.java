package com.design.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Movie extends BaseModel{
    private String name;


    @ManyToMany
    private List<Actor> actors;

    private int movieRating;
    private String description;
    private Date releaseDate;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;

}
