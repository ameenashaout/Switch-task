package com.example.demo.web.rest;

import com.example.demo.domain.ApplicationUser;
import com.example.demo.domain.Car;

import com.example.demo.exceptions.BusinessException;
import com.example.demo.service.CarService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CarController  extends AbstractResource<Car> {

    public CarController(CarService business) {
        this.business = business;
    }

    @GetMapping("/cars")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DRIVERS')")
    @Override
    public List<Car> getUserDocuments() {
        return super.getUserDocuments();
    }

    @GetMapping("/cars/{cars_id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DRIVERS')")
    @Override
    public Car getDocument(@PathVariable("cars_id") Long documentId)  {

        return super.getDocument(documentId);
    }

    @PostMapping("/cars")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public Car addDocument(@RequestBody Car document) throws BusinessException {
        return super.addDocument(document);
    }

    @PostMapping("/cars/{cars_id}/addCar")
    @PreAuthorize("hasAnyRole('ROLE_DRIVERS')")
    @Override
    public void addCar(@PathVariable("cars_id") Long carId) throws BusinessException {
        super.addCar(carId);
    }

    @PostMapping("/cars/{cars_id}/removeCar")
    @PreAuthorize("hasAnyRole('ROLE_DRIVERS')")
    @Override
    public void removeCar(@PathVariable("cars_id") Long carId) throws BusinessException {
    super.removeCar(carId);
    }

    @DeleteMapping("/cars/{cars_id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public void deleteDocument(@PathVariable("cars_id") Long documentId) throws BusinessException {
        super.deleteDocument(documentId);
    }
}
