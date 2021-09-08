package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends ApplicationRepository<Car, Long> {

}
