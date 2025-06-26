package com.csrent.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="user_email", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="space_id", nullable = false)
    private Space space;
    private LocalDate dateReservation;
    private String status;


    public Reservation() {

    }

    public Reservation(Integer id, User user, Space space, LocalDate dateReservation, String status) {
        this.id = id;
        this.user = user;
        this.space = space;
        this.dateReservation = dateReservation;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
