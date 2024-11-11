package com.design.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class RoomType extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<RoomFeature> roomFeatureList;

    @OneToOne
    private RoomTypePrice roomTypePrice;

    @OneToMany
    private List<Room> rooms;

}
