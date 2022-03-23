package com.ngt.service;

import com.ngt.entity.Employee;
import org.apache.poi.ss.usermodel.Sheet;


import java.util.List;

public interface EmployeeService {
    public List<Employee> processEmployeeCreation(Sheet sheet);
}
