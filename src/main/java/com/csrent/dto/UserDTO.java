package com.csrent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDTO {
    @NotBlank(message = "El nombre no puede quedar en blanco")
    private String name;
    @Email(message = "El correo no cumple con la estructura")
    @NotBlank(message = "El correo no puede quedar en blanco")
    private String email;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$",
            message = "Expresión regular (lo que necesitamos que tenga), debería de llevar mayúsculas,minúsculas,etc.")
    private String password;
    @NotBlank(message = "El campo rol no puede quedar en blnaco")
    private String rol;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password, String rol) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
