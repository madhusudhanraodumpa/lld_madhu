package com.design.hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class RoomTypePrice extends BaseModel{

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private RoomType roomType;

    private Date date;
    private int price;
}
