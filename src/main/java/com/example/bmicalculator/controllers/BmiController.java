package com.example.bmicalculator.controllers;

import com.example.bmicalculator.services.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bmi")
public class BmiController {

    private final BmiService bmiService;

    @Autowired
    public BmiController(BmiService bmiService) {
        this.bmiService = bmiService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, String>> calculateBmi(@RequestBody BmiRequest request) {
        String result = bmiService.calculateBmi(request.getWeight(), request.getHeight());
        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        return ResponseEntity.ok(response);
    }
}
