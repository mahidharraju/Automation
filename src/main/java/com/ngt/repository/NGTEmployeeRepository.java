package com.ngt.repository;

import com.ngt.entity.NGTEmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NGTEmployeeRepository extends JpaRepository<NGTEmployeeData, Integer> {

}
