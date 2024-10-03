package com.design.parkinglot.repositories;

import com.design.parkinglot.model.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    Map<Long,Ticket> ticketMap = new HashMap<>();
    private long lastSavedId = 0L;
    public Ticket saveTicket(Ticket ticket) {
        ticket.setId(lastSavedId+1);
        lastSavedId=lastSavedId+1;
        ticketMap.put(lastSavedId,ticket);
        return ticket;
    }
    public Optional<Ticket> getTicketById(Long Id){
        return Optional.ofNullable(ticketMap.get(Id));
    }
}
