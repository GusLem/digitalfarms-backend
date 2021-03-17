package com.challenge.DigitalFarm.resources;

import com.challenge.DigitalFarm.models.Mill;
import com.challenge.DigitalFarm.service.MillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/mill")
@RequiredArgsConstructor
public class MillResource {

    private final MillService millService;

    @GetMapping
    public ResponseEntity<List<Mill>> getAllMills() {
        List<Mill> mills = millService.findAll();
        return new ResponseEntity<>(mills, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mill> addMill(@RequestBody Mill mill) {
        Mill newMill = millService.add(mill);
        return new ResponseEntity<>(newMill,HttpStatus.CREATED);
    }

}
