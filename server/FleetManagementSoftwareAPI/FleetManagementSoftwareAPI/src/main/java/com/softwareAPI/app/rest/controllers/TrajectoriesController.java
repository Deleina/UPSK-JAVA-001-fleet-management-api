package com.softwareAPI.app.rest.controllers;


import com.softwareAPI.app.rest.models.Trajectories;
import com.softwareAPI.app.rest.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trajectories")
public class TrajectoriesController {
    @Autowired
    private TrajectoriesRepository repository;
    @GetMapping("/all")
    public List<Trajectories> listTrajectoriesByTaxi() {
        return repository.findAll();
    }

    @GetMapping("/{trajectoryId}")
    public ResponseEntity<Trajectories> getTrajectoryById(@PathVariable Integer trajectoryId) {
        Optional<Trajectories> trajectory = repository.findById(trajectoryId);

        if (trajectory.isPresent()) {
            return ResponseEntity.ok(trajectory.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/last")
    public List<Trajectories> listLastTrajectoriesByTaxi() {
        List<Trajectories> trajectoriesList = this.repository.findAll();
        for (Trajectories trajectory: trajectoriesList ){
            System.out.println((trajectory.getTaxi().getLicense()));
        }
        return trajectoriesList;
    }

}
