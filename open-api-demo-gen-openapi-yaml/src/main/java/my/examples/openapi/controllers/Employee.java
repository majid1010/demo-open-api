package my.examples.openapi.controllers;

import lombok.Data;

@Data
public class Employee {
    private String id;
    private String name;
    private String familyName;
    private EmployeeStatus status;
}
