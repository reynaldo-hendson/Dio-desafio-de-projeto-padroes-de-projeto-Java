package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *  Implementação da <b>Strategy</b> {@link ParkingSpotRepository}, a qual pode ser
 *  injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 *  {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
  */

@Service
public class ParkingSpotService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    // Strategy: Implementa os métodos definidos na interface do JpaRepository.
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
        return parkingSpotRepository.save(parkingSpotModel);
    }



    //Method FindAll
    public List<ParkingSpotModel> findAll() {
        return parkingSpotRepository.findAll();
    }
    //Method findById
    public Optional<ParkingSpotModel> findById(Long id) {
        return parkingSpotRepository.findById(id);
    }
    //Method Delete
    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }


    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean exitsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment,block);
    }
}
