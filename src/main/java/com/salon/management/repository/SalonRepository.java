package com.salon.management.repository;

import com.salon.management.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SalonRepository extends JpaRepository<Salon, Long> {
}