package com.challenge.DigitalFarm.resources;

import com.challenge.DigitalFarm.models.Field;
import com.challenge.DigitalFarm.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/field")
@RequiredArgsConstructor
public class FieldResource {

    private final FieldService fieldService;

    @GetMapping
    public ResponseEntity<List<Field>> getAllFields() {
        List<Field> fields = fieldService.findAll();
        return new ResponseEntity<>(fields,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Field> addField(@RequestBody /*FieldDTO fieldDTO*/ Field field) {
        Field newField = fieldService.add(field/*DTO*/);
        return new ResponseEntity<>(newField,HttpStatus.CREATED);
    }

}
