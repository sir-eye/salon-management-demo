package com.example.salonmanagement.service;

import com.example.salonmanagement.entity.Salon;

import java.util.List;

public interface SalonService {
    List<Salon> getAllSalons();
    Salon getSalonById(Long id);
    Salon createSalon(Salon salon);
    Salon updateSalon(Long id, Salon salon);
    void deleteSalon(Long id);
}
