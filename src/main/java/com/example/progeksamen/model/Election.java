package com.example.progeksamen.model;


import javax.persistence.*;

@Entity
@Table(name = "elections")
public class Election {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long electionId;

    private int year;

    private String type;


    public Election() {
    }

    public Election(Long electionId, int year, String type) {
        this.electionId = electionId;
        this.year = year;
        this.type = type;
    }

    public Long getElectionId() {
        return electionId;
    }

    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
