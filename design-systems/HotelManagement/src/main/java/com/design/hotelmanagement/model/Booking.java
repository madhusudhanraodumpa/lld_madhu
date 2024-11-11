package com.design.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
public class Booking extends BaseModel{
    @OneToOne
    private Hotel hotel;
    private Date checkInDate;
    private Date checkOutDate;

    @OneToMany
    private List<RoomType> roomTypes;

    private Date bookingDate;
    @OneToOne
    private User user;
    private int totalAmount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

}
