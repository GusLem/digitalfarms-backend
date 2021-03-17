package com.challenge.DigitalFarm.resources;

import com.challenge.DigitalFarm.models.Harvest;
import com.challenge.DigitalFarm.service.HarvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/harvest")
@RequiredArgsConstructor
public class HarvestResource {

    private final HarvestService harvestService;

    @GetMapping
    public ResponseEntity<List<Harvest>> getAllHarvests() {
        List<Harvest> harvests = harvestService.findAll();
        return new ResponseEntity<>(harvests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Harvest> addHarvest(@RequestBody  Harvest harvest) {
        Harvest newHarvest = harvestService.add(harvest);
        return new ResponseEntity<>(newHarvest, HttpStatus.CREATED);
    }



}
