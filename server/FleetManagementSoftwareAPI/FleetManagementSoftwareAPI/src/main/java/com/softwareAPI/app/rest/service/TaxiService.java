package com.softwareAPI.app.rest.service;

import com.softwareAPI.app.rest.models.Taxi;
import com.softwareAPI.app.rest.models.Trajectories;
import com.softwareAPI.app.rest.repository.TaxiRepository;
import com.softwareAPI.app.rest.repository.TrajectoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaxiService {
    private  final TaxiRepository taxiRepository;
    private final TrajectoriesRepository trajectoriesRepository;
    private Taxi updateTaxi;

    public TaxiService(TaxiRepository taxiRepository, TrajectoriesRepository trajectoriesRepository){
        this.taxiRepository= taxiRepository;
        this.trajectoriesRepository= trajectoriesRepository;
    }

    public List<Taxi> getAllTheTaxis(){
        return taxiRepository.findAll();
    }

    public List<Trajectories> getTrajectoriesByTaxiId(Integer taxiId){
        return trajectoriesRepository.listTrajectories(taxiId);
    }

    public Taxi createTaxi(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    public void deleteTaxi(int id) {
        taxiRepository.deleteById(id);
    }

    public Taxi updateTaxi(int id, Taxi taxi) {
        Taxi existingTaxi= taxiRepository.findById(id).orElse(null);
        if (existingTaxi != null){
            existingTaxi.setLicense(updateTaxi.getLicense());
            return taxiRepository.save(existingTaxi);
        }

        return null;
    }

    public Taxi getTaxiById(int id) {
        return taxiRepository.findById(id).orElse(null);
    }
}
