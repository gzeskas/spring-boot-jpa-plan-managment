package com.example.services;

import com.example.entity.Feature;
import com.example.entity.Plan;
import com.example.repository.FeaturesRepository;
import com.example.repository.PlanRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by gzeska on 05/03/2017.
 */
public class FeaturesServiceJpaImpl implements FeaturesService {

    private final PlanRepository planRepository;

    private final FeaturesRepository featuresRepository;

    public FeaturesServiceJpaImpl(PlanRepository planRepository,
                                  FeaturesRepository featuresRepository) {
        this.planRepository = planRepository;
        this.featuresRepository = featuresRepository;
    }

    @Override
    public List<Feature> findByPlanId(Integer planId) {
        return planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("Plan with id:" + planId +" doesn't exist"))
                .getFeatures();
    }

    @Override
    public Feature addFeatureToPlan(int planId, String newFeatureName) {
        Optional<Feature> featureOptional = featuresRepository.findByName(newFeatureName);
        if (featureOptional.isPresent()) {
            return featureOptional.get();
        }



        return null;
    }

    @Override
    public void removeFeatureToPlan(Plan plan, Feature feature) {
        throw new IllegalAccessError("Not implemented");
    }
}
