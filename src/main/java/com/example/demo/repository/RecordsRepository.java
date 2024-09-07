package com.example.demo.repository;

import com.example.demo.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository extends JpaRepository<Record, Long> {
}
