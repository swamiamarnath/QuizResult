package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.QuizResult;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
    // You can add custom query methods if needed
}
