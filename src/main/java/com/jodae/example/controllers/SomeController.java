package com.jodae.example.controllers;

import com.jodae.example.models.SomeModel;
import com.jodae.example.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SomeController {

    @Autowired
    SomeService someService;

    @GetMapping(value = "/all")
    public List<SomeModel> findAll() {
        return someService.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public SomeModel findById(@PathVariable(value = "id") Integer id) {
        return someService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody SomeModel something) {
        try {
            return new ResponseEntity<>(someService.add(something),
                    HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable(value = "name") String name) {
        try {
            return new ResponseEntity<>(someService.deleteByName(name), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
