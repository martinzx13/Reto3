package com.doctor.reto3.repository.crudRepository;

import com.doctor.reto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
