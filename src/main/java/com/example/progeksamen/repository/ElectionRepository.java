package com.example.progeksamen.repository;

import com.example.progeksamen.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}