package com.kwork.orgibiz.repository;

import com.kwork.orgibiz.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByRegionId(Long regionId);
}
