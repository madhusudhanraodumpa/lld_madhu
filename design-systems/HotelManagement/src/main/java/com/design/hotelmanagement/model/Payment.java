package com.design.hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Payment extends BaseModel{
    private int amount;
    private Date paymentDate;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private int ref_id;


    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;

    @ManyToOne
    private Booking booking;
}
