package com.ngt.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employee_project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeProject {

    @Id
    @Column(name = "GGID")
    private Integer ggid;

    @Column(name = "project_id")
    private UUID projectId;

    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "project_start_date")
    private Date projectStartDate;

    @Column(name = "project_roll_off_date")
    private Date projectRollOffDate;



}
