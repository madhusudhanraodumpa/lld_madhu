package com.design.parkinglot.controller;

import com.design.parkinglot.dto.GenerateTicketRequestDto;
import com.design.parkinglot.dto.GenerateTicketResponseDto;
import com.design.parkinglot.dto.ResponseStatus;
import com.design.parkinglot.exception.InvalidGateException;
import com.design.parkinglot.exception.NoAvailableSlotException;
import com.design.parkinglot.model.Ticket;
import com.design.parkinglot.service.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto createTicket(GenerateTicketRequestDto generateTicketRequestDto) {

        GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
        Ticket ticket = new Ticket();
        try {
            ticket = ticketService.createTicket(generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getGateId(),
                    generateTicketRequestDto.getVehicleType());
        } catch (NoAvailableSlotException e) {
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            generateTicketResponseDto.setMessage("No slots are available currently.");
            return generateTicketResponseDto;

        }catch (InvalidGateException e) {
        generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        generateTicketResponseDto.setMessage("Invalid gate entry");
        return generateTicketResponseDto;
        }
        generateTicketResponseDto.setTicketId(ticket.getId());
        generateTicketResponseDto.setSlotNumber(ticket.getParkingSlot().getSlotNumber());
        generateTicketResponseDto.setOperatorName(ticket.getOperator().getName());


        return generateTicketResponseDto;

        //return ticket object
        // taking input while creating ticket is vehicle  and gate
        //but user dont complete object of vehicle and gate. so need to send gate id and vehicle number and vehicle type.
        //so returning ticket object directly ti user it wont be good becuase we can send directly model object to user. becuase some
        //of the model details hide for user so that we will create request object and ser requries values to user.
        // and als insted passing mutiple value to controller insted of that user need to pass request dto.
    }
}
