package com.design.parkinglot.service;

import com.design.parkinglot.exception.InvalidGateException;
import com.design.parkinglot.exception.NoAvailableSlotException;
import com.design.parkinglot.model.*;
import com.design.parkinglot.repositories.GateRepository;
import com.design.parkinglot.repositories.ParkingLotRepository;
import com.design.parkinglot.repositories.TicketRepository;
import com.design.parkinglot.repositories.VehicleRepository;
import com.design.parkinglot.strategies.slotAssignmentStrategy.SlotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SlotAssignmentStrategy slotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         SlotAssignmentStrategy slotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.slotAssignmentStrategy= slotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Long vehicleNumber , Long gateId, VehicleType vehicleType) throws InvalidGateException,NoAvailableSlotException{
 /*
        Gate = get gate for that id from db. Else throw an exception
        Operator = from gate
        Vehicle = check if already in DB. If yes, get that. Else, create
        ParkingSpot = strategy
        Ticket ticket =
         */
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()) {
            throw  new InvalidGateException();
        }
        Gate gate = gateOptional.get();
        Operator operator = gate.getOperator();
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle=vehicleRepository.createVehicle(vehicle);
        }else {
            vehicle = vehicleOptional.get();
        }
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotOfGate(gate);

        if(parkingLotOptional.isEmpty()) {
            throw new RuntimeException();
        }

        ParkingLot parkingLot = parkingLotOptional.get();

        Optional<ParkingSlot> parkingSlotOptional = slotAssignmentStrategy.findSlot(vehicleType,parkingLot,gate);
        ParkingSlot parkingSlot;
        if(parkingSlotOptional.isEmpty()) {
            throw new NoAvailableSlotException("No Slot available currently");
        } else {
            parkingSlot= parkingSlotOptional.get();
        }
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setParkingSlot(parkingSlot);
        ticket = ticketRepository.saveTicket(ticket);
        return ticket;

    }
}
