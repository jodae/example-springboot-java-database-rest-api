package com.jodae.example.controllers;

import com.jodae.example.entities.SomeEntity;
import com.jodae.example.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SomeController {

    @Autowired
    SomeService someService;

    @GetMapping(value = "/all")
    public List<SomeEntity> findAll() {
        return someService.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public SomeEntity findById(@PathVariable(value = "id") Integer id) {
        return someService.findById(id);
    }

    @PostMapping()
    public SomeEntity add(@RequestBody SomeEntity something) {
        return someService.add(something);
    }

    @DeleteMapping(value = "/name/{name}")
    public String deleteByName(@PathVariable(value = "name") String name) {
        return someService.deleteByName(name);
    }

}
