package com.ngt.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @Column(name = "GGID")
    private Integer ggid;

    @Column(name = "LI_LR_ID")
    private String li_lr_id;

    @Column(name = "Region")
    private String region;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Middle_Name")
    private String middleName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "NT_Login_ID")
    private String ntLoginId;

    @Column(name = "Global_Date_of_Joining")
    private Date globalDateOfJoining;

    @Column(name = "Local_Date_of_Joining")
    private Date localDateOfJoining;

    @Column(name = "Supervisor_Full_Name")
    private String supervisorFullName;

    @Column(name = "Supervisor_Email_ID")
    private String supervisorEmailId;

    @Column(name = "Email_ID")
    private String emailId;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "Created_Date")
    private Date createdDate;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Last_Modified_By")
    private String lastModifiedBy;

    @Column(name = "Last_Modified_Date")
    private Date lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "Current_Practice_ID", referencedColumnName = "ID", columnDefinition = "uuid")
    private Practice currentPractice;

    @ManyToOne
    @JoinColumn(name = "Current_Sub_Practice_ID", referencedColumnName = "ID", columnDefinition = "uuid")
    private SubPractice currentSubPractice;

    @ManyToOne
    @JoinColumn(name = "Previous_Practice_ID", referencedColumnName = "ID", columnDefinition = "uuid")
    private Practice previousPractice;

    @ManyToOne
    @JoinColumn(name = "Previous_Sub_Practice_ID", referencedColumnName = "ID", columnDefinition = "uuid")
    private SubPractice previousSubPractice;

    @Column(name = "practice_change_date")
    private Date practiceChangeDate;

}
