package com.sixmentor.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private int team_score;
    private int team_win;
    private int team_match;

    @OneToOne
    @JoinColumn(name = "coach_id")
    private Player coach;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team() {}

    public Team(Long id, String name, int team_score, int team_win, int team_match, Player coach) {
        this.id = id;
        this.name = name;
        this.team_score = team_score;
        this.team_win = team_win;
        this.team_match = team_match;
        this.coach = coach;
    }

   

    public Player getCoach() {
        return coach;
    }

    public void setCoach(Player coach) {
        this.coach = coach;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


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

    public int getTeam_score() {
        return team_score;
    }

    public void setTeam_score(int team_score) {
        this.team_score = team_score;
    }

    public int getTeam_win() {
        return team_win;
    }

    public void setTeam_win(int team_win) {
        this.team_win = team_win;
    }

    public int getTeam_match() {
        return team_match;
    }

    public void setTeam_match(int team_match) {
        this.team_match = team_match;
    }

    

}
