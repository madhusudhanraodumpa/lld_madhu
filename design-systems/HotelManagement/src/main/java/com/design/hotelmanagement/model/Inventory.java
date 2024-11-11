package com.design.hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Setter
@Getter
public class Inventory extends BaseModel{
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private RoomType roomType;
    private Date date;
    private int total_rooms;
    private int available_rooms;
}
