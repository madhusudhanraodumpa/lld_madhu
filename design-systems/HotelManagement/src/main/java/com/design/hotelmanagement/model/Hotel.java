package com.design.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Hotel extends BaseModel{
    private String name;
    private String address;
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private HotelType hotelType;

    @OneToMany
    private List<Room> rooms;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<HotelFuture> hotelFutures;


}
