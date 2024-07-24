package com.example.bmicalculator.services;

import com.example.bmicalculator.models.BmiRecord;
import com.example.bmicalculator.repositories.BmiRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BmiServiceImplTest {

    @InjectMocks
    private BmiServiceImpl bmiService;

    @Mock
    private BmiRecordRepository bmiRecordRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateBmiWithInvalidInput() {
        String result = bmiService.calculateBmi(0, 1.75);
        assertEquals("Weight and height must be positive numbers.", result);
    }

    @Test
    public void testCalculateBmiWithInvalidHeight() {
        String result = bmiService.calculateBmi(70, 0);
        assertEquals("Weight and height must be positive numbers.", result);
    }

    @Test
    public void testCalculateBmi() {
        String result = bmiService.calculateBmi(70, 1.75);
        assertEquals("Your BMI is 22.86", result);

        ArgumentCaptor<BmiRecord> bmiRecordCaptor = ArgumentCaptor.forClass(BmiRecord.class);
        verify(bmiRecordRepository).save(bmiRecordCaptor.capture());
        BmiRecord savedBmiRecord = bmiRecordCaptor.getValue();

        assertEquals(70, savedBmiRecord.getWeight(), 0.01); // Weryfikacja jako double
        assertEquals(1.75, savedBmiRecord.getHeight(), 0.01);
        assertEquals(22.86, savedBmiRecord.getBmi(), 0.01);
    }
}
