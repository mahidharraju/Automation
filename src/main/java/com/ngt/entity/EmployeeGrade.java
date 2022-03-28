package com.ngt.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employee_grade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeGrade {

    @Id
    @Column(name = "GGID")
    private Integer ggid;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Current_Global_Grade")
    private String currentGlobalGrade;

    @Column(name = "Current_Local_Grade")
    private String currentLocalGrade;

    @Column(name = "New_Global_Grade")
    private String newGlobalGrade;

    @Column(name = "New_Local_Grade")
    private String newLocalGrade;

    @Column(name = "Is_Promoted")
    private Boolean isPromoted;

    @Column(name = "Created_Date")
    private Date createdDate;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Last_Modified_Date")
    private Date lastModifiedDate;

}
