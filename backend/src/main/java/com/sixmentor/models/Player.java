package com.sixmentor.models;

import jakarta.persistence.*;

@Entity
@Table(name = "player") // Créera une table "players" dans MySQL
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id") // clé étrangère dans la table Player
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private String main_role;

    
    private String playerRank;

    private int total_matchs;
    private int total_kills;
    private int total_assists;
    private int total_death;

    public Player() {}

    public Player(Long id, User user, Team team, String main_role, String rank, int total_matchs, int total_kills,
            int total_assists, int total_death, String playerRank) {
        this.id = id;
        this.user = user;
        this.team = team;
        this.main_role = main_role;
        this.playerRank = playerRank;
        this.total_matchs = total_matchs;
        this.total_kills = total_kills;
        this.total_assists = total_assists;
        this.total_death = total_death;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getMain_role() {
        return main_role;
    }

    public void setMain_role(String main_role) {
        this.main_role = main_role;
    }

    public String getplayerRank() {
        return playerRank;
    }

    public void setplayerRank(String playerRank) {
        this.playerRank = playerRank;
    }

    public int getTotal_matchs() {
        return total_matchs;
    }

    public void setTotal_matchs(int total_matchs) {
        this.total_matchs = total_matchs;
    }

    public int getTotal_kills() {
        return total_kills;
    }

    public void setTotal_kills(int total_kills) {
        this.total_kills = total_kills;
    }

    public int getTotal_assists() {
        return total_assists;
    }

    public void setTotal_assists(int total_assists) {
        this.total_assists = total_assists;
    }

    public int getTotal_death() {
        return total_death;
    }

    public void setTotal_death(int total_death) {
        this.total_death = total_death;
    }
    
    
}
