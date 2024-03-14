package com.ums.dto;

import com.ums.entity.Office;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfficeBranchDto {
    private String branchName;
    private String branchCode;
    private Office office;
    private Boolean isDeleted;
}