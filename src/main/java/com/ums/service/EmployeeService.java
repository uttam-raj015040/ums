package com.ums.service;

import com.ums.dto.EmployeeDto;
import com.ums.entity.Employee;
import com.ums.exception.CustomException;
import com.ums.repository.IEmployee;
//import com.ums.utils.enums.Role;
import com.ums.repository.IOfficeBranch;
import com.ums.entity.OfficeBranch;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Service
public class EmployeeService {
    @Autowired
    private IEmployee employeeRepo;

    @Autowired
    private IOfficeBranch officeBranchRepo;


    public Employee createEmployee(EmployeeDto employeeDetails, String officeBranchId) {
        OfficeBranch officeBranch = officeBranchRepo.findById(officeBranchId).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "NOT FOUND"));

        Employee newEmployee = new Employee();
        newEmployee.setName(employeeDetails.getName());
        newEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        newEmployee.setSalary(employeeDetails.getSalary());
        newEmployee.setOfficeBranch(officeBranch);

        // Save the new Employee
        return employeeRepo.save(newEmployee);
    }


public List<Employee> getEmployeeWithHighSalary(String officeBranchId, int minSalary) {
    return employeeRepo.findEmployeeWithHighSalary(officeBranchId, minSalary);
}

}
