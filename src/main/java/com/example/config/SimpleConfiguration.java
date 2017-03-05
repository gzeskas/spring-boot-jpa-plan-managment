package com.example.config;

import com.example.repository.FeaturesRepository;
import com.example.repository.PlanRepository;
import com.example.services.FeaturesService;
import com.example.services.FeaturesServiceJpaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gzeska on 05/03/2017.
 */
@Configuration
public class SimpleConfiguration {

    @Bean
    FeaturesService getFeaturesService(PlanRepository planRepository, FeaturesRepository featuresRepository) {
        return new FeaturesServiceJpaImpl(planRepository, featuresRepository);
    }

}
