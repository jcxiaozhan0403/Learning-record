package com.example.demo;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BMITest {
    double weight = 45;
    double height = 1.6;

    @Test
    void bmi() {
        BMI bmi = EasyMock.createMock(BMI.class);
        EasyMock.expect(bmi.bmi(weight,height)).andReturn("偏瘦");
        EasyMock.replay(bmi);
        EasyMock.verify(bmi);
    }
}