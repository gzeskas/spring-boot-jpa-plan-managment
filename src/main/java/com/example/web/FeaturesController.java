package com.example.web;

import com.example.entity.Feature;
import com.example.services.FeaturesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gzeska on 05/03/2017.
 */
@RestController
@RequestMapping("/plans/{planId}/features")
public class FeaturesController {

    private final FeaturesService featuresService;

    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @GetMapping
    public List<Feature> getFeatures(@PathVariable("planId") int planId) {
        return featuresService.findByPlanId(planId);
    }

}
