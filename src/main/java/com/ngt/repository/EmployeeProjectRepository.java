package com.ngt.repository;

import com.ngt.entity.Account;
import com.ngt.entity.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Integer> {

}
