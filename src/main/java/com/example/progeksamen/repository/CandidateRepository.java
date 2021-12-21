package com.example.progeksamen.repository;

import com.example.progeksamen.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {


    // Var ikke sikker på, om det var det her der mentes i opgave 2c?
    // Alternativt kan man få et parti og alle dets medlemmer ved at bruge PartyControlleren og tilhørende repo.
    @Query(value = "select * from candidates where party_id = ?;", nativeQuery = true)
    List<Candidate> getCandidatesByPartyId(Long id);

    Candidate findByFirstNameAndLastName(String firstName, String lastName);
}
