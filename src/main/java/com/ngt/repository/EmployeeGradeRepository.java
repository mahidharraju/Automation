package com.ngt.repository;

import com.ngt.entity.EmployeeGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeGradeRepository extends JpaRepository<EmployeeGrade, Integer> {

}
