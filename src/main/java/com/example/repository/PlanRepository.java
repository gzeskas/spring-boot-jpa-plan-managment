package com.example.repository;

import com.example.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by gzeska on 05/03/2017.
 */
public interface PlanRepository extends JpaRepository<Plan, Integer> {
    Optional<Plan> findById(Integer id);
    Optional<Plan> findByName(String name);
}
