package com.kwork.orgibiz.service;

import com.kwork.orgibiz.model.Country;
import com.kwork.orgibiz.model.Region;
import com.kwork.orgibiz.repository.CountryRepository;
import com.kwork.orgibiz.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions(){
        return regionRepository.findAll();
    }
    public List<Region> getRegionsByCountry(Long countryId){
        return regionRepository.findByCountryId(countryId);
    }
}
