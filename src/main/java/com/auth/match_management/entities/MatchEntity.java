package com.auth.match_management.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "football_match")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "team_home_name")
    private String teamHomeName;

    @Column(name = "team_away_name")
    private String teamAwayName;

    @Column(name = "team_home_goals")
    private int teamHomeGoals;

    @Column(name = "team_away_goals")
    private int teamAwayGoals;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamHomeName() {
        return teamHomeName;
    }

    public void setTeamHomeName(String teamHomeName) {
        this.teamHomeName = teamHomeName;
    }

    public String getTeamAwayName() {
        return teamAwayName;
    }

    public void setTeamAwayName(String teamAwayName) {
        this.teamAwayName = teamAwayName;
    }

    public int getTeamHomeGoals() {
        return teamHomeGoals;
    }

    public void setTeamHomeGoals(int teamHomeGoals) {
        this.teamHomeGoals = teamHomeGoals;
    }

    public int getTeamAwayGoals() {
        return teamAwayGoals;
    }

    public void setTeamAwayGoals(int teamAwayGoals) {
        this.teamAwayGoals = teamAwayGoals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
