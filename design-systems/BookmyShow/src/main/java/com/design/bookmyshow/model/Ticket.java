package com.design.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private Movie movie;

    @ManyToMany
    private List<Seat> seats;

    private int amount;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

    private Date bookingTime;

    @ManyToOne
    private Show show;

    @ManyToOne
    private User bookedBy;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;


}
