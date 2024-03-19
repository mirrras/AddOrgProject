package com.kwork.orgibiz.service;

import com.kwork.orgibiz.model.City;
import com.kwork.orgibiz.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
    public List<City> getCitiesByRegion(Long regionId){
        return cityRepository.findByRegionId(regionId);
    }
}
