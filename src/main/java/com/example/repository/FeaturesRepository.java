package com.example.repository;

import com.example.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by gzeska on 05/03/2017.
 */
public interface FeaturesRepository extends JpaRepository<Feature, Integer> {
    Optional<Feature> findByName(String newFeatureName);
}
