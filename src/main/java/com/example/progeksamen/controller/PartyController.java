package com.example.progeksamen.controller;

import com.example.progeksamen.model.Party;
import com.example.progeksamen.repository.PartyRepository;
import com.fasterxml.classmate.Annotations;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Transient;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/parties")
@CrossOrigin(origins = {"http://localhost:63342",  "http://localhost:5000"})
public class PartyController {

    PartyRepository partyRepository;

    public PartyController(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @GetMapping
    public ResponseEntity<List<Party>> findAll() throws NoSuchFieldException, IllegalAccessException{

        return ResponseEntity.ok(partyRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> findById(@PathVariable ("id") Long id) {
        if (partyRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(partyRepository.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
