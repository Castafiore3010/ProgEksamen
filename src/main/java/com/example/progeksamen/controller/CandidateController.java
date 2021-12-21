package com.example.progeksamen.controller;

import com.example.progeksamen.model.Candidate;
import com.example.progeksamen.model.Party;
import com.example.progeksamen.repository.CandidateRepository;
import com.example.progeksamen.repository.PartyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@CrossOrigin(origins = {"http://localhost:63342",  "http://localhost:5000"})

public class CandidateController {

    CandidateRepository candidateRepository;
    PartyRepository partyRepository;

    public CandidateController(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;

    }

    @GetMapping
    public ResponseEntity<List<Candidate>> findAll() {
        List<Candidate> list = candidateRepository.findAll();
        list.forEach(c -> {
            c.setPartyName(c.getParty().getPartyName());
        });
        return ResponseEntity.ok(candidateRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable ("id") Long id) {
        if (candidateRepository.findById(id).isPresent()) {
            Candidate c = candidateRepository.findById(id).get();
            c.setPartyName(c.getParty().getPartyName());
            return ResponseEntity.ok(c);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Candidate> create(@RequestBody Candidate candidate) {
        Candidate managedCandidate = new Candidate(candidate.getCandidateId(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getPersonalVotes());

        if (candidate.getParty() != null) {
            if (partyRepository.findById(candidate.getParty().getPartyId()).isPresent()) {
                Party party = partyRepository.findById(candidate.getParty().getPartyId()).get();
                managedCandidate.setParty(party);
            }

        }
        return ResponseEntity.status(201).body(candidateRepository.save(managedCandidate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> edit(@RequestBody Candidate candidate, @PathVariable ("id") Long id) {

        if (candidateRepository.findById(id).isPresent()) {
            Candidate candidateToUpdate = candidateRepository.findById(id).get();
            candidateToUpdate.setFirstName(candidate.getFirstName());
            candidateToUpdate.setLastName(candidate.getLastName());
            if (candidate.getParty() != null) {
                if (partyRepository.findById(candidate.getParty().getPartyId()).isPresent()) {
                    Party party = partyRepository.findById(candidate.getParty().getPartyId()).get();
                    candidateToUpdate.setParty(party);
                }
            }
            candidateToUpdate.setPersonalVotes(candidate.getPersonalVotes());

            return ResponseEntity.ok(candidateRepository.save(candidateToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Candidate> delete(@PathVariable ("id") Long id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
