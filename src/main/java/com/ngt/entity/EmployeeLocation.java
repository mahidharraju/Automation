package com.ngt.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employee_location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeLocation {

    @Id
    @Column(name = "GGID")
    private Integer ggid;

    @Column(name = "Location")
    private String location;

    @Column(name = "Base_Location")
    private String baseLocation;

    @Column(name = "Location_Standardization")
    private String locationStandardization;

    @Column(name = "Created_Date")
    private Date createdDate;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Last_Modified_Date")
    private Date lastModifiedDate;

}
