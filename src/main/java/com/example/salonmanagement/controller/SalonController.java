package com.example.salonmanagement.controller;

import com.example.salonmanagement.entity.Salon;
import com.example.salonmanagement.service.SalonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    private final SalonService salonService;

    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @GetMapping
    public ResponseEntity<List<Salon>> getAllSalons() {
        return ResponseEntity.ok(salonService.getAllSalons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salon> getSalonById(@PathVariable Long id) {
        return ResponseEntity.ok(salonService.getSalonById(id));
    }

    @PostMapping
    public ResponseEntity<Salon> createSalon(@RequestBody Salon salon) {
        return ResponseEntity.ok(salonService.createSalon(salon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salon> updateSalon(@PathVariable Long id, @RequestBody Salon salon) {
        return ResponseEntity.ok(salonService.updateSalon(id, salon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable Long id) {
        salonService.deleteSalon(id);
        return ResponseEntity.noContent().build();
    }
}
