
package com.ums.controller;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.response.ResponseModel;
import com.ums.service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
@Validated
public class EmployeeController {



    @Autowired
    EmployeeService employeeService;

    /*                                     Employee creation                              */




    @PostMapping("/create")
    public Employee createUser(@Valid @RequestBody EmployeeDto employeeDetails,
                               @RequestParam(name = "officeBranchId") String officeBranchId) {
        System.out.println("User creation API is called!");
        return employeeService.createEmployee(employeeDetails, officeBranchId);
    }






    @GetMapping("/by-branch-and-salary")
    public List<Employee> getEmployeesWithHighSalary(
            @RequestParam(name = "officeBranchId") String officeBranchId,
            @RequestParam(name = "minSalary") int minSalary
    ) {
        return employeeService.getEmployeeWithHighSalary(officeBranchId, minSalary);
    }






}