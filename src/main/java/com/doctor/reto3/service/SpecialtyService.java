package com.doctor.reto3.service;


import com.doctor.reto3.model.Specialty;
import com.doctor.reto3.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll(){
        return specialtyRepository.getAll();
    }

    public Optional<Specialty> getById(Integer id){
        return specialtyRepository.getById(id);
    }

    public Specialty save(Specialty specialty){
        if (specialty.getId()==null){
            return specialtyRepository.save(specialty);
        } else {
            Optional<Specialty> optionalSpeciality= specialtyRepository.getById(specialty.getId());
            if (optionalSpeciality.isEmpty()){
                return specialtyRepository.save(specialty);
            }else {
                return specialty;

            }
        }
    }

    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty> optionalSpeciality= specialtyRepository.getById(specialty.getId());
            if (!optionalSpeciality.isEmpty()){
                if (specialty.getName()!=null){
                    optionalSpeciality.get().setName(specialty.getName());
                }
                if (specialty.getDescription()!=null){
                    optionalSpeciality.get().setDescription(specialty.getDescription());
                }
                specialtyRepository.save(optionalSpeciality.get());
                return optionalSpeciality.get();
            } else {
                return specialty;
            }
        }else {
            return specialty;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(specialty -> {
            specialtyRepository.delete(specialty);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
