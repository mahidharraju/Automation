package com.ngt.service.impl;

import com.ngt.entity.Employee;
import com.ngt.repository.NGTEmployeeRepository;
import com.ngt.rest.NGTCreationRequest;
import com.ngt.rest.NGTCreationResponse;
import com.ngt.service.EmployeeService;
import com.ngt.service.NGTService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class NGTServiceImpl implements NGTService {


    @Autowired
    EmployeeService employeeService;

    @Autowired
    NGTEmployeeRepository ngtEmployeeRepository;

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
            XSSFSheet shadowEmpSheet=wb.getSheetAt(0);
            XSSFSheet billableEmpSheet=wb.getSheetAt(1);

            List<Employee> employees = processEmpData(shadowEmpSheet, billableEmpSheet);
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


    private List<Employee> processEmpData(Sheet shadowEmpSheet , Sheet billableEmpSheet) {
        return employeeService.processEmployeeNGTData(shadowEmpSheet , billableEmpSheet);
    }
}
