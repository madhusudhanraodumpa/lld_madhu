package com.design.bookmyshow.controller;

import com.design.bookmyshow.dto.BookTicketRequestDto;
import com.design.bookmyshow.dto.BookTicketResponseDto;
import com.design.bookmyshow.exception.InvalidArgumentsException;
import com.design.bookmyshow.exception.SeatNotAvailableException;
import com.design.bookmyshow.exception.ShowNotFoundException;
import com.design.bookmyshow.model.Ticket;
import com.design.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;

@Controller
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();

        try {
            Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getSeatIds(),bookTicketRequestDto.getUserId(), bookTicketRequestDto.getShowId());
            bookTicketResponseDto.setAmount(ticket.getAmount());
            bookTicketResponseDto.setTicketId(ticket.getId());
            bookTicketResponseDto.setAuditoriumName(ticket.getShow().getAuditorium().getAudiName());
            bookTicketResponseDto.setSeatNumbers(ticket.getSeats().stream().map(e->e.getSeatNumber()).toList());
            bookTicketResponseDto.setStatus("SUCCESS");
            bookTicketResponseDto.setMessage("Ticket are created successfully.");
        } catch (ShowNotFoundException e) {
            bookTicketResponseDto.setMessage("Show not found"+e.getMessage());
            bookTicketResponseDto.setStatus("FAILED");
            return bookTicketResponseDto;
        } catch (SeatNotAvailableException e) {
            bookTicketResponseDto.setMessage("Seats are not available"+e.getMessage());
            bookTicketResponseDto.setStatus("FAILED");
            return bookTicketResponseDto;
        } catch (InvalidArgumentsException e) {
            bookTicketResponseDto.setMessage("invalid user"+ e.getMessage());
            return bookTicketResponseDto;
        }
        return null;
    }
}
