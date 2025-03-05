package com.sixmentor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players") // Créera une table "players" dans MySQL
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int kills;
    private int assists;

    // Constructeurs
    public Player() {}

    public Player(String name, int kills, int assists) {
        this.name = name;
        this.kills = kills;
        this.assists = assists;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
}
