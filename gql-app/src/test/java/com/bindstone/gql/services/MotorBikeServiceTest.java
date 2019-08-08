package com.bindstone.gql.services;

import com.bindstone.gql.entities.MotorBike;
import com.bindstone.gql.sevices.MotorBikeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MotorBikeServiceTest {

    @Autowired
    MotorBikeService motorBikeService;

    @Test
    public void run() {
        MotorBike motorBike = new MotorBike();
        motorBike.setConstructor("Harley Davidson");
        motorBike.setName("Fat Boy");
        motorBike.setYear(2019);

        MotorBike save = motorBikeService.save(motorBike);
        Assertions.assertNotNull(save);
        Assertions.assertNotNull(save.getId());
        Long id = save.getId();

        MotorBike find = motorBikeService.getById(id);
        Assertions.assertNotNull(find);

        motorBikeService.delete(find);
    }
}
