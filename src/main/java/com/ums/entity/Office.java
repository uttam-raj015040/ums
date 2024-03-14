
package com.ums.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "offices")
public class Office extends Base {

    @NotEmpty(message = "officename is required")
    @Column(unique = true)
    private String officeName;

    @NotEmpty(message = "region is required")
    private String region;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<OfficeBranch> officeBranches;

    private Boolean isDelete = false;

}

