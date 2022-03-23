package com.ngt.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

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
    private int ggid;

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
    private Boolean active ;

    @Column(name = "Created_Date")
    private Date createdDate ;

    @Column(name = "Created_By")
    private String createdBy ;

    @Column(name = "Last_Modified_By")
    private String lastModifiedBy ;

    @Column(name = "Last_Modified_Date")
    private Date lastModifiedDate ;

}
