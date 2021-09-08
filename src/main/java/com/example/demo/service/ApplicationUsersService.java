package com.example.demo.service;


import com.example.demo.domain.ApplicationUser;

import com.example.demo.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BusinessException;

import java.util.Map;



@Service
public class ApplicationUsersService extends AbstractService<ApplicationUser> {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private ApplicationUserRepository repository;

	public ApplicationUsersService(ApplicationUserRepository repository) {
		super.repository = repository;
	}


	@Override
	public void saveDocument(ApplicationUser document) throws BusinessException {

		ApplicationUser applicationUser = repository.getUserByUsername(document.getUsername());

		if (applicationUser != null && !applicationUser.getId().equals(document.getId())) {
			throw new BusinessException("");
		}

		if (document.getId() == null) {

			document.setPassword(encoder.encode(document.getPassword()));

		}
		super.saveDocument(document);

	}







}
