package com.example.demo.repository;

import com.example.demo.domain.Manufacturer;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends ApplicationRepository<Manufacturer, Long> {
}
