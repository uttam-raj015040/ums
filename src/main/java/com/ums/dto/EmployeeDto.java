package com.ums.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
 private String name;
 private Double phoneNumber;
 private Double salary;
 private String officeBranchId;
 private Boolean isDeleted;
 private Boolean isValid;


 public void setOfficeBranchId(String officeBranchId) {
  this.officeBranchId = officeBranchId;
 }


}
