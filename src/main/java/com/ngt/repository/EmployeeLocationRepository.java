package com.ngt.repository;

import com.ngt.entity.EmployeeGrade;
import com.ngt.entity.EmployeeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLocationRepository extends JpaRepository<EmployeeLocation, Integer> {

}
