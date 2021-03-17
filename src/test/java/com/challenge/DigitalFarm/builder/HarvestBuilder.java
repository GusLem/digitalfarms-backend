package com.challenge.DigitalFarm.builder;

import com.challenge.DigitalFarm.models.Harvest;
import com.challenge.DigitalFarm.repos.HarvestRepo;
import com.challenge.DigitalFarm.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HarvestBuilder {

    @Autowired
    private HarvestService harvestService;

    @Autowired
    private MillBuilder millBuilder;

    public Harvest createHarvest() {
        Harvest harvest = new Harvest();
        harvest.setStartDate(new Date());
        harvest.setEndDate(new Date());

        harvest.setMill(millBuilder.persistMill());

        return harvest;
    }

    public Harvest persistHarvest() {
        return harvestService.add(createHarvest());
    }

}
