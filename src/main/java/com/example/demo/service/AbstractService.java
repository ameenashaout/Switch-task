package com.example.demo.service;


import com.example.demo.configuration.ApplicationConfig;
import com.example.demo.domain.AbstractAuditingEntity;

import com.example.demo.domain.ApplicationUser;
import com.example.demo.domain.Car;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.repository.ApplicationUserRepository;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractService<T extends AbstractAuditingEntity> {

	protected static final String LOGOS_FOLDER_NAME = "logos";

	@Autowired
	protected ApplicationConfig applicationConfig;



    @Autowired
    protected CarRepository carRepository;

    @Autowired
    protected ApplicationUserRepository applicationRepository;

	protected ApplicationRepository<T, Long> repository;

	public final List<T> findUserDocuments() {

		return (List<T>) getRepository().findAll();

	}
	public T getDocument(Long id) {
		return getRepository().findById(id).orElse(null);
	}

    public void saveCar(Long carId) throws BusinessException {
	Car car = carRepository.findById(carId).orElse(null);
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String name= authentication.getName();
	long driverId=applicationRepository.getUserByUsername(name).getId();
	if (car.getdriverId() == 00){

    car.setdriverId(driverId);
    carRepository.save(car);
	}
	else {
		throw new BusinessException("CarAlreadyInUseException");
	}
	}
	public void deleteCar(Long carId) throws BusinessException {
		Car car = carRepository.findById(carId).orElse(null);
			car.setdriverId(00);
			carRepository.save(car);
	}


	public void saveDocument(T document) throws BusinessException {
		getRepository().save(document);
	}



	public void deleteDocument(Long id) throws BusinessException {
		getRepository().deleteById(id);
	}

	public ApplicationRepository<T, Long> getRepository() {
		return repository;
	}


}
