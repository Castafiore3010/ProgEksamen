package com.example.progeksamen.repository;

import com.example.progeksamen.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query(value = "select * from candidates where party_id = ?;", nativeQuery = true)
    List<Candidate> getCandidatesByPartyId(Long id);
    Candidate findByFirstNameAndLastName(String firstName, String lastName);
}
