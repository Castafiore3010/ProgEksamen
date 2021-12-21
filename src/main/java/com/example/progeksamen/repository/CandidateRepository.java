package com.example.progeksamen.repository;

import com.example.progeksamen.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    public Candidate findByFirstNameAndLastName(String firstName, String lastName);
}
