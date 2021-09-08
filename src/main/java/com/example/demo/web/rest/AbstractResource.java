package com.example.demo.web.rest;

import com.example.demo.domain.Car;
import com.example.demo.exceptions.BusinessException;

import com.example.demo.domain.AbstractAuditingEntity;
import com.example.demo.service.AbstractService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public  class AbstractResource<T extends AbstractAuditingEntity> {

    protected AbstractService<T> business;
    public List<T> getUserDocuments() {
        return business.findUserDocuments();
    }



    public T getDocument(Long documentId) {
        return business.getDocument(documentId);
    }

    public T addDocument(T document) throws BusinessException {
        business.saveDocument(document);
        return document;
    }

    public void addCar(Long carId) throws BusinessException {
        business.saveCar(carId);
    }
    public void removeCar(Long carId) throws BusinessException {
        business.deleteCar(carId);
    }
    public void updateDocument(long documentId, T document) throws BusinessException {
        document.setId(documentId);
        business.saveDocument(document);
    }

    public void deleteDocument(Long documentId) throws BusinessException {
        business.deleteDocument(documentId);
    }



}
