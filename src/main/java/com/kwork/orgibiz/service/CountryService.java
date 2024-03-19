package com.kwork.orgibiz.service;

import com.kwork.orgibiz.model.Country;
import com.kwork.orgibiz.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
}
