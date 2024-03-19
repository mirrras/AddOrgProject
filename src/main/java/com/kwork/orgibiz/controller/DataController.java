package com.kwork.orgibiz.controller;

import com.kwork.orgibiz.model.City;
import com.kwork.orgibiz.model.Country;
import com.kwork.orgibiz.model.Region;
import com.kwork.orgibiz.service.CityService;
import com.kwork.orgibiz.service.CountryService;
import com.kwork.orgibiz.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private CityService cityService;

    @GetMapping("/country")
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }
    @GetMapping("/region")
    public List<Region> getAllRegions(){
        return regionService.getAllRegions();
    }
    @GetMapping("/region/{countryId}")
    public List<Region> getRegionsByCountry(@PathVariable Long countryId){
        return regionService.getRegionsByCountry(countryId);
    }
    @GetMapping("/city")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }
    @GetMapping("/city/{regionId}")
    public List<City> getCitiesByRegion(@PathVariable Long regionId){
        return cityService.getCitiesByRegion(regionId);
    }

}
