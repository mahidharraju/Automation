package com.ngt.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "project_pu_name")
    private String projectPuName;

    @Column(name = "project_name")
    private String projectName;

    @Column(name="project_number")
    private int projectNumber;
}
