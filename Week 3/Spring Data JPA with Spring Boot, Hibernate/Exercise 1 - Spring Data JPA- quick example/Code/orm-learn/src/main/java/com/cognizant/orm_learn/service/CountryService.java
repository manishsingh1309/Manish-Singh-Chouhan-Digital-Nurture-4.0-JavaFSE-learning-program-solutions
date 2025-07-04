package com.cognizant.orm_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.CountryRepository;
import com.cognizant.orm_learn.model.*;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    public CountryRepository repo;

    public List<Country> getAllCountries(){
        return repo.findAll();
    }
}
