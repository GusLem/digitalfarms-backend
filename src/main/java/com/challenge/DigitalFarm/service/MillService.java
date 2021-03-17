package com.challenge.DigitalFarm.service;

import com.challenge.DigitalFarm.models.Mill;
import com.challenge.DigitalFarm.repos.MillRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MillService {

    private final MillRepo millRepo;

    public List<Mill> findAll() {
        return millRepo.findAll();
    }

    public Mill add(/*MillDTO millDTO*/Mill mill) {
        //Mill mill = millMapper.toEntity(millDTO);
        return millRepo.save(mill);
    }

}
