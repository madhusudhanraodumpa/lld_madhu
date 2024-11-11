package com.design.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowz;
    private int colz;
    @ManyToOne
    private SeatType seatType;
}
