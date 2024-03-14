package com.ums.service;

import com.ums.entity.Office;
import com.ums.exception.CustomException;
import com.ums.repository.IOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    private IOffice officeRepo;

    public Office createOffice(Office officeDetails) {
        return officeRepo.save(officeDetails);
    }

    public Office getOfficeDetails(String officeId) {
        Optional<Office> officeOptional = officeRepo.findById(officeId);
        return officeOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Office Not Found"));
    }



}
