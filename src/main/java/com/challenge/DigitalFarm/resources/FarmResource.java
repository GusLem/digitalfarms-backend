package com.challenge.DigitalFarm.resources;

import com.challenge.DigitalFarm.models.Farm;
import com.challenge.DigitalFarm.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/farm")
@RequiredArgsConstructor
public class FarmResource {

    private final FarmService farmService;

    @GetMapping
    public ResponseEntity<List<Farm>> getAllFarms() {
        List<Farm> farms = farmService.findAll();
        return new ResponseEntity<>(farms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Farm> addFarm(@RequestBody Farm farm) {
        Farm newFarm = farmService.add(farm);
        return new ResponseEntity<>(newFarm, HttpStatus.CREATED);
    }

}
