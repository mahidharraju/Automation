package com.ngt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Sub_practice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubPractice {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="currentSubPractice")
    private Set<Employee> employees;

   /* @JsonIgnore
    @OneToMany(mappedBy="newSubPractice")
    private Set<Employee> newSubPracticeEmployees;*/
}
