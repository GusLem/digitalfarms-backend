package com.challenge.DigitalFarm.builder;

import com.challenge.DigitalFarm.models.Field;
import com.challenge.DigitalFarm.repos.FieldRepo;
import com.challenge.DigitalFarm.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldBuilder {

    @Autowired
    private FieldService fieldService;

    @Autowired
    private FarmBuilder farmBuilder;

    public Field createField() {
        Field field = new Field();

        field.setLatitude(-20.0);
        field.setLongitude(-40.0);

        return field;
    }

    public Field persistField() {
        return fieldService.add(createField());
    }


}
