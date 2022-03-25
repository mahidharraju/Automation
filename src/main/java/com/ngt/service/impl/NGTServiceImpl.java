package com.ngt.service.impl;

import com.ngt.entity.Employee;
import com.ngt.rest.NGTCreationRequest;
import com.ngt.rest.NGTCreationResponse;
import com.ngt.service.EmployeeService;
import com.ngt.service.NGTService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class NGTServiceImpl implements NGTService {


    @Autowired
    EmployeeService employeeService;


    @Override
    public NGTCreationResponse processNewNGTData(NGTCreationRequest ngtCreationRequest) {
       FileInputStream ngtDataFile = null;
        NGTCreationResponse resp = null;
        try {
            ngtDataFile = new FileInputStream(
                    new File(ngtCreationRequest.getFilePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            XSSFWorkbook wb=new XSSFWorkbook (ngtDataFile);
            XSSFSheet sheet=wb.getSheetAt(0);
            List<Employee> employees = processEmpData(sheet);
            resp = NGTCreationResponse
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

    @Override
    public NGTCreationResponse updateNGTData(NGTCreationRequest ngtCreationRequest) {
        return null;
    }

    private List<Employee> processEmpData(Sheet sheet) {
        return employeeService.processEmployeeCreation(sheet);
    }
}
