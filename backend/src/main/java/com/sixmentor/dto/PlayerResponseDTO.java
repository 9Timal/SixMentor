package com.sixmentor.dto;

public class PlayerResponseDTO {
    private Long id;               // ID du joueur
    private String firstname;      // Prénom du user
    private String lastname;       // Nom du user
    private String email;          // Email du user
    private String mainRole;       // Rôle principal du joueur
    private String rank;           // Rang du joueur
    private int totalMatchs;
    private int totalKills;
    private int totalAssists;
    private int totalDeath;
    private String status;         // Statut du user (par ex. "Actif", "Banni", etc.)
    private String role;           // Rôle dans l'app (user, admin, etc.)


    public PlayerResponseDTO(Long id, String firstname, String lastname, String email, String mainRole, String rank,
            int totalMatchs, int totalKills, int totalAssists, int totalDeath, String status, String role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mainRole = mainRole;
        this.rank = rank;
        this.totalMatchs = totalMatchs;
        this.totalKills = totalKills;
        this.totalAssists = totalAssists;
        this.totalDeath = totalDeath;
        this.status = status;
        this.role = role;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getMainRole() {
        return mainRole;
    }


    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }


    public String getRank() {
        return rank;
    }


    public void setRank(String rank) {
        this.rank = rank;
    }


    public int getTotalMatchs() {
        return totalMatchs;
    }


    public void setTotalMatchs(int totalMatchs) {
        this.totalMatchs = totalMatchs;
    }


    public int getTotalKills() {
        return totalKills;
    }


    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }


    public int getTotalAssists() {
        return totalAssists;
    }


    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }


    public int getTotalDeath() {
        return totalDeath;
    }


    public void setTotalDeath(int totalDeath) {
        this.totalDeath = totalDeath;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    

    
}