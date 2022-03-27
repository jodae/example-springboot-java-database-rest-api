package com.jodae.example.services;

import com.jodae.example.models.SomeModel;
import com.jodae.example.repositories.SomeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class SomeService {

    @Autowired
    SomeRepository someRepository;

    public List<SomeModel> findAll(){
        return someRepository.findAll();
    }

    public SomeModel findById(Integer id) {
        return someRepository.findById(id).orElse(null);
    }

    public SomeModel add(SomeModel something) throws IllegalArgumentException {
        if (someRepository.existsByName(something.getName())) {
            throw new IllegalArgumentException("Name already exists!");
        } else {
            return someRepository.save(something);
        }
    }

    @Transactional
    public String deleteByName(String name)throws IllegalArgumentException {
        if (someRepository.existsByName(name)) {
            Integer id = someRepository.getByName(name).getId();
            someRepository.deleteByName(name);
            return "Element with id " + id + " deleted!";
        } else {
            throw new IllegalArgumentException("Not found!");
        }
    }
}
