package com.jodae.example.services;

import com.jodae.example.entities.SomeEntity;
import com.jodae.example.exceptions.ResourceNotAcceptableException;
import com.jodae.example.exceptions.ResourceNotFoundException;
import com.jodae.example.repositories.SomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SomeService {

    @Autowired
    SomeRepository someRepository;

    public List<SomeEntity> findAll() {
        return someRepository.findAll();
    }

    public SomeEntity findById(Integer id) {
        return someRepository.findById(id).orElse(null);
    }

    public SomeEntity add(SomeEntity something) {
        try {
            return someRepository.save(something);
        } catch (Exception ex) {
            throw new ResourceNotAcceptableException("Name empty or name already exists !");
        }
    }

    @Transactional
    public String deleteByName(String name) {
        if (someRepository.existsByName(name)) {
            someRepository.deleteByName(name);
            return "Element with name " + name + " deleted!";
        } else {
            throw new ResourceNotFoundException("Name not found !");
        }
    }
}
