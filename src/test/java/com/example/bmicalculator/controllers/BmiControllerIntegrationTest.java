package com.example.bmicalculator.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BmiControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateBmi() throws Exception {
        String requestBody = "{\"weight\":70,\"height\":1.75}";

        mockMvc.perform(post("/api/bmi/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Your BMI is 22.86"))); // Kropka jako separator dziesiętny
    }
}
