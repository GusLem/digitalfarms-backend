package com.challenge.DigitalFarm.builder;

import com.challenge.DigitalFarm.models.Farm;
import com.challenge.DigitalFarm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FarmBuilder {

    @Autowired
    private FarmService farmService;

    @Autowired
    private HarvestBuilder harvestBuilder;

    public Farm createFarm() {
        Farm farm = new Farm();

        farm.setName("Batatão");

        return farm;
    }

    public Farm persistFarm() {
        return farmService.add(createFarm());
    }
}
