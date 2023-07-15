package my.examples.openapi.codegen.application.services;


import my.examples.openapi.codegen.application.domain.models.DomainEmployee;

public interface EmployeeService {
    DomainEmployee loadEmployee(String id);
    DomainEmployee addEmployee(DomainEmployee employee);
    void deleteEmployee(String id);
}
