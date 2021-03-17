package com.challenge.DigitalFarm.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mill")
public class Mill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "mill_id")
    private List<Harvest> harvests;
}
