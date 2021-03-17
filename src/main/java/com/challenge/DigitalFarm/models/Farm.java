package com.challenge.DigitalFarm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "farm")
public class Farm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "farm_id")
    private List<Field> fields;

    @ManyToOne
    @JoinColumn(name = "harvest_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Harvest harvest;

}
