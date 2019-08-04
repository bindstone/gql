package com.bindstone.gql.sevices;

import com.bindstone.gql.entities.MotorBike;

import java.util.List;

public interface MotorBikeService {

    MotorBike save(MotorBike motorBike);
    MotorBike getById(Long id);
    void delete(MotorBike motorBike);
    List<MotorBike> getAll();

}
