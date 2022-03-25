package com.ngt.rest;

import com.ngt.entity.Employee;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NGTCreationResponse {

    private List<Employee> employees;
}
