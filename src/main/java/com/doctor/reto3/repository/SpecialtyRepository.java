package com.doctor.reto3.repository;

import com.doctor.reto3.model.Specialty;
import com.doctor.reto3.repository.crudRepository.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class SpecialtyRepository {
    @Autowired
private SpecialtyCrudRepository specialtyCrudRepository;

    public List<Specialty> getAll(){
        return (List<Specialty>) specialtyCrudRepository.findAll();
    }

    public Optional<Specialty> getById(Integer idSpecialty){

        return specialtyCrudRepository.findById(idSpecialty);
    }

    public Specialty save(Specialty specialty){
        return specialtyCrudRepository.save(specialty);

    }

    public void delete(Specialty specialty){
        specialtyCrudRepository.delete(specialty);
    }
}