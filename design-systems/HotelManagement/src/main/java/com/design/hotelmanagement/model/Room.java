package com.design.hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room extends BaseModel{
    private int roomNumber;
    private int floorNumber;
    @OneToOne
    private RoomType roomType;


}
