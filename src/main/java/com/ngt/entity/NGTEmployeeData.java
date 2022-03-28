package com.ngt.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NGTEmployeeData")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NGTEmployeeData {

    @Id
    @Column(name = "GGID")
    private Integer ggid;

    @Column(name = "Shadow_Start_Date")
    private Date shadowStartDate;

    @Column(name = "Shadow_End_Date")
    private Date shadowEndDate;

    @Column(name = "Shadow_Account")
    private String shadowAccount;

    @Column(name = "FLP_Skills")
    private String flpSKills;

    @Column(name = "NGT_Status")
    private String NGTStatus;

    /*@Column(name = "Billable_Start_Date")
    private Date billableStartDate;

    @Column(name = "Duration_Days")
    private Integer durationDays;

    @Column(name = "Duration_Weeks")
    private Integer durationWeeks;

    @Column(name = "Contact_Number")
    private Integer contactNumber;

    @Column(name = "Billable_ReqID")
    private Integer billableReqID;
*/
    @Column(name = "Created_Date")
    private Date createdDate;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Last_Modified_Date")
    private Date lastModifiedDate;

}
