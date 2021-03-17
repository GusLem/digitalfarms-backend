package com.challenge.DigitalFarm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "harvest")
public class Harvest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Date startDate;
    private Date endDate;

    @OneToMany
    @JoinColumn(name = "harvest_id")
    private List<Farm> farms;

    @ManyToOne
    @JoinColumn(name = "mill_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Mill mill;

}
