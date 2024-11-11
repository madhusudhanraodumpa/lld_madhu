package com.design.bookmyshow.repositories;

import com.design.bookmyshow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {


    Ticket save(Ticket ticket);
}
