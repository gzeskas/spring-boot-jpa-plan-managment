package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzeska on 05/03/2017.
 */
@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "plan_features",
            inverseJoinColumns = {
                @JoinColumn(name = "feature_id", referencedColumnName = "id")
            }
    )
    private List<Feature> features;

    /**
     * for Jpa
     */
    private Plan() {
    }

    public Plan(String name) {
        this.id = null;
        this.name = name;
        this.features = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean addFeature(Feature feature) {
        return this.features.add(feature);
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
