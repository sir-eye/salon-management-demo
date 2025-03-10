package com.salon.management.service;

import com.salon.management.model.Salon;
import com.salon.management.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    public Optional<Salon> getSalonById(Long id) {
        return salonRepository.findById(id);
    }

    public Salon createSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    public void deleteSalon(Long id) {
        salonRepository.deleteById(id);
    }

    public Salon updateSalon(Long id, Salon updatedSalon) {
        return salonRepository.findById(id)
                .map(product -> {
                    Salon salon = new Salon();
                    salon.setName(updatedSalon.getName());
                    salon.setPrice(updatedSalon.getPrice());
                    salon.setDescription(updatedSalon.getDescription());
                    return salonRepository.save(salon);
                })
                .orElseThrow(() -> new RuntimeException("Salon not found"));
    }
}