package com.doctor.reto3.repository.crudRepository;


import com.doctor.reto3.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}

