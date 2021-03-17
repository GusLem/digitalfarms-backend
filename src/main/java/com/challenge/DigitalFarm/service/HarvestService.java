package com.challenge.DigitalFarm.service;

import com.challenge.DigitalFarm.models.Harvest;
import com.challenge.DigitalFarm.repos.HarvestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HarvestService {

    private final HarvestRepo harvestRepo;

    public List<Harvest> findAll() {
        return harvestRepo.findAll();
    }

    public Harvest add(Harvest harvest/*HarvestDTO harvestDTO*/) {
        //Harvest harvest = harvestMapper.toEntity(harvestDTO);
        return harvestRepo.save(harvest);
    }

}
