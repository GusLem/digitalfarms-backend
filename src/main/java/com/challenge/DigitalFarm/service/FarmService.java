package com.challenge.DigitalFarm.service;

import com.challenge.DigitalFarm.models.Farm;
import com.challenge.DigitalFarm.repos.FarmRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepo farmRepo;

    public List<Farm> findAll() {
        return farmRepo.findAll();
    }

    public Farm add(Farm farm/*FarmDTO farmDTO*/) {
        //Farm farm = farmMapper.toEntity(farmDTO);
        return farmRepo.save(farm);
    }

}
