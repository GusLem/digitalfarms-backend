package com.challenge.DigitalFarm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "field")
public class Field implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Farm farm;

}
