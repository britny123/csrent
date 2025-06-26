package com.csrent.service;

import com.csrent.dto.ReservationDTO;
import com.csrent.model.Reservation;
import com.csrent.model.Space;
import com.csrent.model.User;
import com.csrent.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private UserService userService;
    private SpaceService spaceService;

    public ReservationService(ReservationRepository reservationRepository, UserService userService, SpaceService spaceService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.spaceService = spaceService;
    }

    public List<Reservation>getAll(){
        return reservationRepository.findAll();
    }

    public Reservation add (ReservationDTO reservationDTO){
        User user = userService.getUserByEmail(reservationDTO.getEmailUser());
        Space space = spaceService.getSpace(reservationDTO.getIdSpace());
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setSpace(space);
        reservation.setDateReservation(reservationDTO.getDate());
        reservation.setStatus(reservationDTO.getStatus());
        return reservationRepository.save(reservation);
    }
}
