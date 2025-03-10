package com.salon.management.controller;

import com.salon.management.service.SalonService;
import com.salon.management.model.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salon")
class SalonController {
    @Autowired
    private SalonService salonService;

    @GetMapping
    public List<Salon> getAllSalons() {
        return salonService.getAllSalons();
    }

    @GetMapping("/{id}")
    public Optional<Salon> getSalonById(@PathVariable Long id) {
        return salonService.getSalonById(id);
    }

    @PostMapping("/{id}")
    public Salon updateSalon(Long id, Salon updatedSalon) {
        return salonService.updateSalon(id, updatedSalon);
    }


}