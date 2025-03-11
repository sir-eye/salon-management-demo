package com.example.salonmanagement.service;

import com.example.salonmanagement.entity.Salon;
import com.example.salonmanagement.exception.ResourceNotFoundException;
import com.example.salonmanagement.repository.SalonRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {

    private static final Logger logger = LoggerFactory.getLogger(SalonServiceImpl.class);
    private final SalonRepository salonRepository;

    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public List<Salon> getAllSalons() {
        logger.info("Retrieving all salons");
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long id) {
        logger.info("Retrieving salon with id: {}", id);
        return salonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found with id " + id));
    }

    @Override
    @Transactional
    public Salon createSalon(Salon salon) {
        logger.info("Creating new salon: {}", salon.getName());
        return salonRepository.save(salon);
    }

    @Override
    @Transactional
    public Salon updateSalon(Long id, Salon salonDetails) {
        logger.info("Updating salon with id: {}", id);
        Salon existingSalon = getSalonById(id);
        existingSalon.setName(salonDetails.getName());
        existingSalon.setAddress(salonDetails.getAddress());
        existingSalon.setPhoneNumber(salonDetails.getPhoneNumber());
        return salonRepository.save(existingSalon);
    }

    @Override
    @Transactional
    public void deleteSalon(Long id) {
        logger.info("Deleting salon with id: {}", id);
        Salon salon = getSalonById(id);
        salonRepository.delete(salon);
    }
}
