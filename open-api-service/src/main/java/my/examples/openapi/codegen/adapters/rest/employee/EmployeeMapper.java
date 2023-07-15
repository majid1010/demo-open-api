package my.examples.openapi.codegen.adapters.rest.employee;


import my.examples.openapi.codegen.application.domain.models.DomainEmployee;
import my.examples.openapi.codegen.application.domain.models.EmployeeStatus;
import my.examples.openapis.employee.server.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    DomainEmployee mapToDomain(Employee employee){
        DomainEmployee domainEmployee = new DomainEmployee();
        domainEmployee.setId(employee.getId());
        domainEmployee.setFirstName(employee.getName());
        domainEmployee.setLastName(employee.getFamilyName());
        domainEmployee.setStatus(EmployeeStatus.valueOf(employee.getStatus().name()));
        return domainEmployee;
    }

    Employee mapToDto(DomainEmployee domainEmployee){
        if(domainEmployee == null)
            return null;
        Employee employee = new Employee();
        employee.setId(domainEmployee.getId());
        employee.setName(domainEmployee.getFirstName());
        employee.setFamilyName(domainEmployee.getLastName());
        employee.setStatus(Employee.StatusEnum.valueOf(domainEmployee.getStatus().name()));
        return employee;

    }
}
