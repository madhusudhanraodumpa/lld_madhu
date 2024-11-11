package com.design.bookmyshow.repositories;

import com.design.bookmyshow.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {


    List<Seat> findAllByIdIn(List<Long> seatIds);
}
