package com.softwareAPI.app.rest.controllers;

import com.softwareAPI.app.rest.models.Taxi;
import com.softwareAPI.app.rest.repository.TaxiRepository;
import com.softwareAPI.app.rest.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taxis")
public class TaxiController {
    @Autowired
    private TaxiRepository repository;
    @GetMapping("/")
    public List<Taxi> list(){
        return repository.findAll();
    }
}
