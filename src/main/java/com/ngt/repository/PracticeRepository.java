package com.ngt.repository;

import com.ngt.entity.Employee;
import com.ngt.entity.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, UUID> {

    public Practice findByName(String practiceName);

}
