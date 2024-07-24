package com.example.bmicalculator.repositories;

import com.example.bmicalculator.models.BmiRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BmiRecordRepository extends JpaRepository<BmiRecord, Long> {
}

