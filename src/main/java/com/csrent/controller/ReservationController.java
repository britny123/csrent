package com.csrent.controller;

import com.csrent.dto.ReservationDTO;
import com.csrent.model.Reservation;
import com.csrent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>>getAll(){
        return ResponseEntity.ok(reservationService.getAll());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(reservationService.add(reservationDTO));
    }



}
