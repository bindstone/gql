package com.bindstone.gql.sevices.impl;

import com.bindstone.gql.entities.MotorBike;
import com.bindstone.gql.repositories.MotorBikeRepository;
import com.bindstone.gql.sevices.MotorBikeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MotorBikeServiceImpl implements MotorBikeService {

    private MotorBikeRepository motorBikeRepository;

    public MotorBikeServiceImpl(MotorBikeRepository motorBikeRepository) {
        this.motorBikeRepository = motorBikeRepository;
    }

    @Override
    public MotorBike save(MotorBike motorBike) {
        return motorBikeRepository.save(motorBike);
    }

    @Override
    public MotorBike getById(Long id) {
        return motorBikeRepository.getOne(id);
    }

    @Override
    public void delete(MotorBike motorBike) {
        motorBikeRepository.delete(motorBike);
    }

    @Override
    public List<MotorBike> getAll() {
        return motorBikeRepository.findAll();
    }
}
