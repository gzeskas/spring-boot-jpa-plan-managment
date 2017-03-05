package com.example.services;

import com.example.entity.Feature;
import com.example.entity.Plan;

import java.util.List;

/**
 * Created by gzeska on 05/03/2017.
 */
public interface FeaturesService {
    List<Feature> findByPlanId(Integer planId);
    Feature addFeatureToPlan(int planId, String newFeatureName);
    void removeFeatureToPlan(Plan plan, Feature feature);
}
