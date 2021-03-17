package com.challenge.DigitalFarm.repos;

import com.challenge.DigitalFarm.models.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepo extends JpaRepository<Farm, Long> {
}
