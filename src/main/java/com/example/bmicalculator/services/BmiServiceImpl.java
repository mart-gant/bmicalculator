package com.example.bmicalculator.services;

import com.example.bmicalculator.models.BmiRecord;
import com.example.bmicalculator.repositories.BmiRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BmiServiceImpl implements BmiService {

    private final BmiRecordRepository bmiRecordRepository;

    @Autowired
    public BmiServiceImpl(BmiRecordRepository bmiRecordRepository) {
        this.bmiRecordRepository = bmiRecordRepository;
    }

    @Override
    public String calculateBmi(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            return "Weight and height must be positive numbers.";
        }

        double bmi = weight / (height * height);
        String bmiResult = String.format(Locale.US, "Your BMI is %.2f", bmi);

        BmiRecord bmiRecord = new BmiRecord();
        bmiRecord.setWeight(weight); // Przechowywanie wagi jako double
        bmiRecord.setHeight(height);
        bmiRecord.setBmi(bmi);

        bmiRecordRepository.save(bmiRecord);

        return bmiResult;
    }
}
