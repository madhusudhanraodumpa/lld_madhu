package com.design.bookmyshow.service;

import com.design.bookmyshow.exception.InvalidArgumentsException;
import com.design.bookmyshow.exception.SeatNotAvailableException;
import com.design.bookmyshow.exception.ShowNotFoundException;
import com.design.bookmyshow.model.*;
import com.design.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(SeatRepository seatRepository, ShowRepository showRepository,
    ShowSeatRepository showSeatRepository
    ,UserRepository userRepository,
                         TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }


   public Ticket bookTicket(List<Long> seatIds, long userId,long showId) throws ShowNotFoundException, SeatNotAvailableException, InvalidArgumentsException {
        // get the seat from db
        //get show seats from db
        //check the all show seats are available or not. if not throw exception
        // if yes then change the status to locked.
        // store in to show seats in to db.
        // the created ticket and store it in to db.

        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);
        Show show = showRepository.findById(showId)
                .orElseThrow(()-> new ShowNotFoundException("Show not found = "+showId));
        List<ShowSeat> showSeats = getAndLockShowSeats(seats, show);


        User user = userRepository.findById(userId).orElseThrow(()->new InvalidArgumentsException("User is not valid = "+userId));

        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        ticket.setAmount(0);
        ticket.setBookingTime(new Date());
        ticket.setBookedBy(user);
        ticket.setSeats(seats);
        ticket.setShow(show);
        ticket = ticketRepository.save(ticket);
       return ticket;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED,timeout = 2)
    public List<ShowSeat> getAndLockShowSeats(List<Seat> seats, Show show) throws SeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, show);
        List<ShowSeat> availableShowSeats = new ArrayList<>();
        for (ShowSeat showSeat :showSeats) {
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)) {
                throw new SeatNotAvailableException("Ops seats are not available.");
            }
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            showSeat.setCreatedDate(new Date());
            showSeat = showSeatRepository.save(showSeat);
            availableShowSeats.add(showSeat);

        }
        return availableShowSeats;
    }
}
