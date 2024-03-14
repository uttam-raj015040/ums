package com.ums.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employees")
public class Employee extends Base {

   // private String id;

    @NotEmpty(message = "employee_name")
    @Column(unique = true)
    private String name;

    @NotNull(message = "Phone number is required")
    private Double phoneNumber;
    @NotNull(message = "Mobile number is required")
    private Double salary;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "office_branch_id")
    private OfficeBranch officeBranch;

    public void setOfficeBranch(OfficeBranch officeBranch) {
        this.officeBranch = officeBranch;
    }


    private Boolean isDelete = false;

}
