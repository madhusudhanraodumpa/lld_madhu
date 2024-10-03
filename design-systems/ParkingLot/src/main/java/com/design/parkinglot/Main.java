package com.design.parkinglot;

import com.design.parkinglot.controller.BillController;
import com.design.parkinglot.controller.TicketController;
import com.design.parkinglot.dto.GenerateBillRequestDto;
import com.design.parkinglot.dto.GenerateTicketRequestDto;
import com.design.parkinglot.dto.GenerateTicketResponseDto;
import com.design.parkinglot.model.VehicleType;
import com.design.parkinglot.repositories.*;
import com.design.parkinglot.service.BillingService;
import com.design.parkinglot.service.TicketService;
import com.design.parkinglot.strategies.feesCalculatoryStrategy.DefaultFeesCalculatorStrategy;
import com.design.parkinglot.strategies.feesCalculatoryStrategy.FeeCalculatorStrategy;
import com.design.parkinglot.strategies.slotAssignmentStrategy.RandomSlotAssignmentStrategy;
import com.design.parkinglot.strategies.slotAssignmentStrategy.SlotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SlotAssignmentStrategy slotAssignmentStrategy = new RandomSlotAssignmentStrategy();
        TicketRepository ticketRepository = new TicketRepository();
        FeeCalculatorStrategy feeCalculatorStrategy = new DefaultFeesCalculatorStrategy();
        BillingRepository billingRepository = new BillingRepository();

        BillingService billingService = new BillingService(gateRepository,ticketRepository,feeCalculatorStrategy,billingRepository);
        TicketService ticketService = new TicketService(gateRepository,vehicleRepository ,slotAssignmentStrategy ,parkingLotRepository,ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto();
        generateTicketRequestDto.setVehicleNumber(0171L);
        generateTicketRequestDto.setVehicleType(VehicleType.BIKE);
        generateTicketRequestDto.setGateId(1L);
        GenerateTicketResponseDto generateTicketResponseDto =ticketController.createTicket(generateTicketRequestDto);

        GenerateBillRequestDto generateBillRequestDto = new GenerateBillRequestDto();
        generateBillRequestDto.setTicketId(generateTicketResponseDto.getTicketId());
        generateBillRequestDto.setGateId(2L);
        BillController billController = new BillController(billingService);
        billController.createBill(generateBillRequestDto);



        System.out.println("Hello world!");
    }
}