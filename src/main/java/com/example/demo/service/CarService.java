package com.example.demo.service;


import com.example.demo.domain.Car;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends AbstractService<Car> {


    public CarService(CarRepository repository) {
        super.repository = repository;
    }

}
