package com.ngt.service.impl;

import com.ngt.entity.Employee;
import com.ngt.repository.NGTEmployeeRepository;
import com.ngt.rest.GADCreationRequest;
import com.ngt.rest.GADCreationResponse;
import com.ngt.service.EmployeeService;
import com.ngt.service.GADService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class GADServiceImpl implements GADService {


    @Autowired
    EmployeeService employeeService;

    @Autowired
    NGTEmployeeRepository ngtEmployeeRepository;

    @Override
    public GADCreationResponse processNewGADData(GADCreationRequest GADCreationRequest) {
       FileInputStream ngtDataFile = null;
        GADCreationResponse resp = null;
        try {
            ngtDataFile = new FileInputStream(
                    new File(GADCreationRequest.getFilePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            XSSFWorkbook wb=new XSSFWorkbook (ngtDataFile);
            XSSFSheet sheet=wb.getSheetAt(0);
            List<Employee> employees = processEmpData(sheet);
            resp = GADCreationResponse
                    .builder()
                    .employees(employees)
                    .build();

      }
        catch(Exception e)
        {
            e.printStackTrace();
        }
         return resp;
    }


    private List<Employee> processEmpData(Sheet sheet) {
        return employeeService.processEmployeeCreation(sheet);
    }
}
