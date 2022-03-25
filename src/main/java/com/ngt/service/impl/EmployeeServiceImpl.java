package com.ngt.service.impl;

import com.ngt.entity.*;
import com.ngt.repository.*;
import com.ngt.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PracticeRepository practiceRepository;

    @Autowired
    SubPracticeRepository subPracticeRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeProjectRepository employeeProjectRepository;

    private static AtomicReference<HashMap<String,Practice>> practiceMap = new
            AtomicReference<>();

    private static AtomicReference<HashMap<String, SubPractice>> subPracticeMap = new
            AtomicReference<>();

    @Override
    public List<Employee> processEmployeeCreation(Sheet sheet) {

        initialisePracticeData();

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
        int practice=16;
        int subPractice=17;
        int ultimateAccountName =22;
        int accountName =23;
        int projectPuName = 24;
        int projectName = 26;
        int projectNumber = 27;
        int projectStartDate= 28;
        int projectRollOffDate = 29;

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
                    else if(cell.getStringCellValue().equalsIgnoreCase("Practice"))
                        practice=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Sub Practice"))
                        subPractice=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Ultimate Account Name"))
                        ultimateAccountName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Account Name"))
                        accountName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Project PU Name"))
                        projectPuName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Project Name"))
                        projectName=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Project Number"))
                        projectNumber=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Project Start Date"))
                        projectStartDate=cell.getColumnIndex();
                    else if(cell.getStringCellValue().equalsIgnoreCase("Project Roll-off Date"))
                        projectRollOffDate=cell.getColumnIndex();
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
                String practiceValue =null;
                String subPracticeValue =null;
                String ultimateAccountNameValue =null;
                String accountNameValue =null;
                String projectPuNameValue = null;
                String  projectNameValue = null;
                int projectNumberValue = 0;
                Date projectStartDateValue= null;
                Date projectRollOffDateValue = null;

                Practice practiceEntity = null;
                SubPractice subPracticeEntity = null;
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
                    else if(cell.getColumnIndex()==ultimateAccountName){
                        DataFormatter formatter = new DataFormatter();
                        ultimateAccountNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==accountName){
                        DataFormatter formatter = new DataFormatter();
                        accountNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==projectPuName){
                        DataFormatter formatter = new DataFormatter();
                        projectPuNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==projectName){
                        DataFormatter formatter = new DataFormatter();
                        projectNameValue = formatter.formatCellValue(cell);
                    }
                    else if(cell.getColumnIndex()==projectNumber){
                        projectNumberValue = Integer.parseInt(cell.getStringCellValue());
                    }
                    else if(cell.getColumnIndex()==projectStartDate){
                        projectStartDateValue = cell.getDateCellValue();
                    }
                    else if(cell.getColumnIndex()==projectRollOffDate){
                        projectRollOffDateValue = cell.getDateCellValue();
                    }
                    else if(cell.getColumnIndex()==practice){
                        DataFormatter formatter = new DataFormatter();
                        practiceValue = formatter.formatCellValue(cell);
                        if(practiceMap.get().get(practiceValue)!=null){
                            practiceEntity = practiceMap.get().get(practiceValue);
                        }
                        else{
                            practiceEntity=practiceRepository.findByName(practiceValue);
                            practiceMap.get().put(practiceValue,practiceEntity);
                        }

                    }else if(cell.getColumnIndex()==subPractice){
                        DataFormatter formatter = new DataFormatter();
                        subPracticeValue = formatter.formatCellValue(cell);
                        if(subPracticeMap.get().get(subPracticeValue)!=null){
                            subPracticeEntity = subPracticeMap.get().get(subPracticeValue);
                        }
                        else{
                            subPracticeEntity=subPracticeRepository.findByName(subPracticeValue);
                            subPracticeMap.get().put(subPracticeValue,subPracticeEntity);
                        }
                    }

                  }
                Account accountEntity = createOrGetAccount(ultimateAccountNameValue,accountNameValue);
                Project projectEntity = createOrGetProject(projectPuNameValue,projectNameValue,projectNumberValue);

                Employee employee = employeeRepository.findByGgid(ggid_value);
                if(employee!=null){
                    if(!employee.getCurrentPractice().getName().equals(practiceValue)){
                        employee.setPreviousPractice(employee.getCurrentPractice());
                        employee.setCurrentPractice(practiceEntity);
                        employee.setPracticeChangeDate(new Date());
                    }
                    if(!employee.getCurrentSubPractice().getName().equals(subPracticeValue)){
                        employee.setPreviousSubPractice(employee.getCurrentSubPractice());
                        employee.setCurrentSubPractice(subPracticeEntity);
                        employee.setPracticeChangeDate(new Date());
                    }
                    employee.setGgid(ggid_value);
                    employee.setLi_lr_id(li_lr_id_value);
                    employee.setRegion(regionValue);
                    employee.setFirstName(fistNameValue);
                    employee.setMiddleName(middleNameValue);
                    employee.setLastName(lastNameValue);
                    employee.setNtLoginId(ntLoginIdValue);
                    employee.setGlobalDateOfJoining(globalDOJValue);
                    employee.setLocalDateOfJoining(localDOJValue);
                    employee.setSupervisorFullName(supervisorFullNameValue);
                    employee.setSupervisorEmailId(supervisorEmailIdValue);
                    employee.setEmailId(emailIdValue);
                    employee.setActive(true);
                    employee.setCreatedDate(new Date());
                    employee.setLastModifiedDate(new Date());
                    employee.setCreatedBy("System");

                }
                else{
                    employee = Employee.builder()
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
                            .currentPractice(practiceEntity)
                            .currentSubPractice(subPracticeEntity)
                            .build();
                }

                employees.add(employeeRepository.save(employee));
                updateEmployeeProject(employee.getGgid(),
                        projectEntity,
                        accountEntity,
                        projectStartDateValue,
                        projectRollOffDateValue);
            }
        }
        return employees;
    }

    private void updateEmployeeProject(Integer ggid,
                                       Project projectEntity,
                                       Account accountEntity,
                                       Date projectStartDate,
                                       Date projectRollOffDate) {
        EmployeeProject empProject = EmployeeProject
                .builder()
                .ggid(ggid)
                .projectId(projectEntity.getId())
                .accountId(accountEntity.getId())
                .projectStartDate(projectStartDate)
                .projectRollOffDate(projectRollOffDate)
                .build();
        employeeProjectRepository.save(empProject);

    }

    private Project createOrGetProject(String projectPuName, String projectName, int projectNumber) {
        Project project = projectRepository.findByNameCodeAndPuName( projectPuName,projectName,projectNumber);
        if(project!=null)
            return project;
        else{
            project = Project
                    .builder()
                    .projectNumber(projectNumber)
                    .projectPuName(projectPuName)
                    .projectName(projectName)
                    .build();
            return projectRepository.save(project);
        }
    }

    private Account createOrGetAccount(String ultimateAccountNameValue, String accountNameValue) {
        Account account = accountRepository.findByUltimateAccountNameAndAccountName
                (ultimateAccountNameValue,accountNameValue);
        if(account!=null)
            return account;
        else{
            account = Account
                    .builder()
                    .ultimateAccountName(ultimateAccountNameValue)
                    .accountName(accountNameValue)
                    .build();
            return accountRepository.save(account);
        }
    }

    private void initialisePracticeData() {
        if(practiceMap.get()==null || practiceMap.get().isEmpty()){
            HashMap map =  new HashMap<String, Practice>();
            practiceMap.set(map);
        }
        if(subPracticeMap.get()==null || subPracticeMap.get().isEmpty()){
            HashMap map =  new HashMap<String, Practice>();
            subPracticeMap.set(map);

        }
    }
}
