package com.example.progeksamen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "municipalities")
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long municipalityId;

    private String name;

    private int eligbleToVote;

    private int votesCast;

    @ManyToOne
    @JoinColumn(name = "election_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Election election;



    public Municipality() {
    }

    public Municipality(Long municipalityId, String name, int eligbleToVote, int votesCast, Election election) {
        this.municipalityId = municipalityId;
        this.name = name;
        this.eligbleToVote = eligbleToVote;
        this.votesCast = votesCast;
        this.election = election;
    }

    public Long getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Long municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEligbleToVote() {
        return eligbleToVote;
    }

    public void setEligbleToVote(int eligbleToVote) {
        this.eligbleToVote = eligbleToVote;
    }

    public int getVotesCast() {
        return votesCast;
    }

    public void setVotesCast(int votesCast) {
        this.votesCast = votesCast;
    }
}


