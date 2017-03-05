package com.example.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gzeska on 05/03/2017.
 */
@Entity
@Table(name = "feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "plan_features",
            inverseJoinColumns = {
                    @JoinColumn(name = "plan_id", referencedColumnName = "id")
            }
    )
    private List<Plan> plans;

    /**
     * For Jpa
     */
    private Feature() {
    }

    public Feature(String name) {
        this.name = name;
        this.id = null;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Plan> getPlans() {
        return plans;
    }
}
