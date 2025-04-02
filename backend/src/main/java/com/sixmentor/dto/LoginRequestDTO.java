package com.sixmentor.dto;

public class LoginRequestDTO {
    private String email;
    private String password;

    // Constructeur vide obligatoire pour le mapping JSON
    public LoginRequestDTO() {}

    // Constructeur complet (facultatif mais pratique)
    public LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters et Setters
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
}
