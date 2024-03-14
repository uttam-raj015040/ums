package com.ums.repository;

import com.ums.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployee extends JpaRepository<Employee, String> {





    @Query(value = "SELECT * FROM employees WHERE office_branch_id = :officeBranchId AND salary > :minSalary ORDER BY salary DESC ", nativeQuery = true)
    //Employee findEmployeeWithHighSalary(@Param("officeBranchId") String officeBranchId, @Param("minSalary") int minSalary);
    List<Employee> findEmployeeWithHighSalary(@Param("officeBranchId") String officeBranchId, @Param("minSalary") int minSalary);
}



