package com.challenge.DigitalFarm.service;

import com.challenge.DigitalFarm.models.Field;
import com.challenge.DigitalFarm.repos.FieldRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FieldService {

    private final FieldRepo fieldRepo;

    public List<Field> findAll() {
        return fieldRepo.findAll();
    }

    public Field add(Field field) {
        return fieldRepo.save(field);
    }

}
