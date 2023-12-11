package com.jodae.example.repositories;


import com.jodae.example.entities.SomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeRepository extends JpaRepository<SomeEntity, Integer> {

    SomeEntity getByName(String name);

    Boolean existsByName(String name);

    void deleteByName(String name);

}
