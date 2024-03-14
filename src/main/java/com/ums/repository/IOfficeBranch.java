package com.ums.repository;

import com.ums.entity.OfficeBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOfficeBranch extends JpaRepository<OfficeBranch, String> {

}


