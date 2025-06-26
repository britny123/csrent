package com.csrent.dto;

import java.time.LocalDate;

public class ReservationDTO {
    private String emailUser;
    private Integer idSpace;
    private LocalDate date;
    private String status;

    public ReservationDTO() {
    }

    public ReservationDTO(String emailUser, Integer idSpace, LocalDate date, String status) {
        this.emailUser = emailUser;
        this.idSpace = idSpace;
        this.date = date;
        this.status = status;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Integer getIdSpace() {
        return idSpace;
    }

    public void setIdSpace(Integer idSpace) {
        this.idSpace = idSpace;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
