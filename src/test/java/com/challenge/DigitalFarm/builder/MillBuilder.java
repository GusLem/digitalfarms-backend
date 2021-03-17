package com.challenge.DigitalFarm.builder;

import com.challenge.DigitalFarm.models.Mill;
import com.challenge.DigitalFarm.repos.MillRepo;
import com.challenge.DigitalFarm.service.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MillBuilder {

    @Autowired
    private MillService millService;

    public Mill createMill() {
        Mill mill = new Mill();

        mill.setName("Batatóide");

        return mill;
    }

    public Mill persistMill() {
        return millService.add(createMill());
    }



}
