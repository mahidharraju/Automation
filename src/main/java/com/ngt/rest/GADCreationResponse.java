package com.ngt.rest;

import com.ngt.entity.Employee;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GADCreationResponse {

    private List<Employee> employees;
}
