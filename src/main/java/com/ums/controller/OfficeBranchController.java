package com.ums.controller;

import com.ums.dto.OfficeBranchDto;
import com.ums.entity.OfficeBranch;
import com.ums.service.OfficeBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/officebranch")
@RestController
@Validated
public class OfficeBranchController {

    @Autowired
    private OfficeBranchService officeBranchService;



    @PostMapping("/create")
    public OfficeBranch createOfficeBranch(@RequestBody OfficeBranchDto officeBranchDetails) {
        return officeBranchService.createOfficeBranch(officeBranchDetails);
    }





    @GetMapping("/details/{branchId}")
    public OfficeBranch getOfficeBranchDetails(@PathVariable(name = "branchId", required = true) String branchId) {
        return officeBranchService.getOfficeBranchDetails(branchId);
    }


}