package com.ums.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ums.dto.OfficeBranchDto;
import com.ums.entity.Employee;
import com.ums.entity.Office;
import com.ums.entity.OfficeBranch;
import com.ums.exception.CustomException;
import com.ums.repository.IOffice;
import com.ums.repository.IOfficeBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Service
public class OfficeBranchService {

    @Autowired
    private IOfficeBranch officeBranchRepo;
    @Autowired
    private IOffice officeRepo;

    public OfficeBranch createOfficeBranch(OfficeBranchDto officeBranchDetails) {
        Office office = officeRepo.findById(officeBranchDetails.getOffice().getId())
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Office Not Found"));
        OfficeBranch officeBranch = new OfficeBranch();
        officeBranch.setBranchName(officeBranchDetails.getBranchName());
        officeBranch.setBranchCode(officeBranchDetails.getBranchCode());
        officeBranch.setOffice(office);
        return officeBranchRepo.save(officeBranch);
    }

    public OfficeBranch getOfficeBranchDetails(String branchId) {
        Optional<OfficeBranch> branchOptional = officeBranchRepo.findById(branchId);
        return branchOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Office Branch Not Found"));
    }





}

