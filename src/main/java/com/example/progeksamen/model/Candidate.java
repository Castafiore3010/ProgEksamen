package com.example.progeksamen.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;

    private String firstName;
    private String lastName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "party_id", nullable = false)
    @JsonBackReference
    private Party party;

    private int personalVotes;

    @Transient
    private String partyName;


    public Candidate() {
    }

    public Candidate(Long candidateId, String firstName, String lastName, int personalVotes) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalVotes = personalVotes;

    }

    public Candidate(Long candidateId, String firstName, String lastName, Party party, int personalVotes) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        this.personalVotes = personalVotes;
    }



    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
        partyName = party.getPartyName();
    }

    public int getPersonalVotes() {
        return personalVotes;
    }

    public void setPersonalVotes(int personalVotes) {
        this.personalVotes = personalVotes;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}
