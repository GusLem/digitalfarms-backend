package com.challenge.DigitalFarm.repos;

import com.challenge.DigitalFarm.models.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepo extends JpaRepository<Harvest, Long> {
}
