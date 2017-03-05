package com.example.repository;

import com.example.entity.Feature;
import com.example.entity.Plan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by gzeska on 05/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class PlanRepositoryTest {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private FeaturesRepository featuresRepository;

    private Feature feature1 = new Feature("first");
    private Feature feature2 = new Feature("second");
    private Feature feature3 = new Feature("third");
    private Feature feature4 = new Feature("four");

    @Before
    public void initTestData() {
        feature1 = featuresRepository.save(feature1);
        feature2 = featuresRepository.save(feature2);
        feature3 = featuresRepository.save(feature3);
        feature4 = featuresRepository.save(feature4);
    }

    @Test
    public void ensure4DefinedPlansAlwaysExists() {
        List<Plan> plans = planRepository.findAll();
        Assert.assertThat(plans.size(), is(4));
    }

    @Test
    public void shouldFind2FeaturesForFirstPlan() {
        Optional<Plan> first = planRepository.findByName("FIRST");
        Assert.assertThat(first.isPresent(), is(true));
        first.get().addFeature(feature1);
        first.get().addFeature(feature4);
        planRepository.save(first.get());
        Optional<Plan> afterSave = planRepository.findByName("FIRST");
        Assert.assertThat(afterSave.isPresent(), is(true));
        Assert.assertThat(afterSave.get().getFeatures().size(), is(2));
    }
}