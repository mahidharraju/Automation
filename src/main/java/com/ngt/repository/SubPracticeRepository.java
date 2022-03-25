package com.ngt.repository;

import com.ngt.entity.Employee;
import com.ngt.entity.Practice;
import com.ngt.entity.SubPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubPracticeRepository extends JpaRepository<SubPractice, UUID> {

    public SubPractice findByName(String practiceName);

}
