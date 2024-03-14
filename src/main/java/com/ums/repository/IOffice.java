
package com.ums.repository;

import com.ums.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOffice extends JpaRepository<Office, String> {

}
