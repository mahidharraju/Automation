package com.ngt.repository;

import com.ngt.entity.Account;
import com.ngt.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    @Query("select  u from Project u where u.projectPuName = :projectPuName and u.projectName =:projectName and u.projectNumber =:projectNumber")
    Project findByNameCodeAndPuName(String  projectPuName , String projectName , int projectNumber);

}
