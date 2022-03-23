package com.ngt.service.impl;

import com.ngt.entity.Employee;
import com.ngt.repository.EmployeeRepository;
import com.ngt.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> processEmployeeCreation(Sheet sheet) {
        List<Employee> employees = new ArrayList<>();
        int li_lr_id =0;
        int gg_id =1;
        int region=3;
        int firstName=4;
        int middleName=5;
        int lastName=6;
        int ntLoginId=7;
        int globalDOJ=8;
        int localDOJ=9;
        int supervisorFullName = 13;
        int supervisorEmailId=14;
        int emailId=15;

        for(Row row :sheet){
            if(row.getRowNum()==0){
                // Headers column
                for(Cell cell : row){
                    if(cell.getStringCellValue().equalsIgnoreCase("LI/LR ID"))
                        li_lr_id= cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("GGID"))
                        gg_id=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Region"))
                        region=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("First Name"))
                        firstName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Middle Name"))
                        middleName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Last Name"))
                        lastName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("NT Login ID"))
                        ntLoginId=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Global Date of Joining"))
                        globalDOJ=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Local Date of Joining"))
                        localDOJ=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Supervisor Full Name"))
                        supervisorFullName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Supervisor Email ID"))
                        supervisorEmailId=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Email ID"))
                        emailId=cell.getColumnIndex();
                }
            }
            break;
        }

        for(Row row :sheet){
            if(row.getRowNum()!=0){
                String li_lr_id_value = null;
                int ggid_value = 0;
                String regionValue=null;
                String fistNameValue=null;
                String middleNameValue=null;
                String lastNameValue=null;
                String ntLoginIdValue=null;
                Date globalDOJValue = null;
                Date localDOJValue =null;
                String supervisorFullNameValue = null;
                String supervisorEmailIdValue =null;
                String emailIdValue =null;
                for(Cell cell : row){
                    if(cell.getColumnIndex()==li_lr_id){
                        DataFormatter formatter = new DataFormatter();
                        li_lr_id_value = formatter.formatCellValue(cell);
                        //li_lr_id_value =  cell.getStringCellValue();
                    }
                    else if(cell.getColumnIndex()==gg_id){
                        ggid_value =  Integer.parseInt(cell.getStringCellValue());
                    }
                    else if(cell.getColumnIndex()==region){
                        DataFormatter formatter = new DataFormatter();
                        regionValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==firstName){
                        DataFormatter formatter = new DataFormatter();
                        fistNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==middleName){
                        DataFormatter formatter = new DataFormatter();
                        middleNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==lastName){
                        DataFormatter formatter = new DataFormatter();
                        lastNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==ntLoginId){
                        DataFormatter formatter = new DataFormatter();
                        ntLoginIdValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==globalDOJ){
                        globalDOJValue = cell.getDateCellValue();

                    }
                    else if(cell.getColumnIndex()==localDOJ) {
                        try {
                            if (cell.getDateCellValue() != null)

                                localDOJValue = cell.getDateCellValue();
                        } catch (Exception e) {
                            log.debug("Date is empty");
                        }
                    }

                    else if(cell.getColumnIndex()==supervisorFullName){
                        DataFormatter formatter = new DataFormatter();
                        supervisorFullNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==supervisorEmailId){
                        DataFormatter formatter = new DataFormatter();
                        supervisorEmailIdValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==emailId){
                        DataFormatter formatter = new DataFormatter();
                        emailIdValue = formatter.formatCellValue(cell);
                    }
                  }
                Employee e = Employee.builder()
                        .ggid(ggid_value)
                        .li_lr_id(li_lr_id_value)
                        .region(regionValue)
                        .firstName(fistNameValue)
                        .middleName(middleNameValue)
                        .lastName(lastNameValue)
                        .ntLoginId(ntLoginIdValue)
                        .globalDateOfJoining(globalDOJValue)
                        .localDateOfJoining(localDOJValue)
                        .supervisorFullName(supervisorFullNameValue)
                        .supervisorEmailId(supervisorEmailIdValue)
                        .emailId(emailIdValue)
                        .active(true)
                        .createdDate(new Date())
                        .lastModifiedDate(new Date())
                        .createdBy("System")
                        .build();
                Employee save = employeeRepository.save(e);
                employees.add(save);
            }
        }
        return employees;
    }
}
