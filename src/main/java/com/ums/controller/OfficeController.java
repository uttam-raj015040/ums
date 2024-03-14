package com.ums.controller;

import com.ums.entity.Office;
import com.ums.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/office")
@RestController
@Validated
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @PostMapping("/create")
    public Office createOffice(@RequestBody Office officeDetails) {
        return officeService.createOffice(officeDetails);
    }

    @GetMapping("/details/{officeId}")
    public Office getOfficeDetails(@PathVariable(name = "officeId", required = true) String officeId) {
        return officeService.getOfficeDetails(officeId);
    }



}
