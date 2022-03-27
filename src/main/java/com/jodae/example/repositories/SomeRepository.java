package com.jodae.example.repositories;


import com.jodae.example.models.SomeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeRepository extends JpaRepository<SomeModel, Integer> {

    SomeModel getByName(String name);

    Boolean existsByName(String name);

    void deleteByName(String name);

}
