package my.examples.openapi.codegen.adapters.rest.employee;

import lombok.extern.slf4j.Slf4j;
import my.examples.openapi.codegen.application.services.EmployeeService;
import my.examples.openapis.employee.server.api.EmployeeApiDelegate;
import my.examples.openapis.employee.server.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeAdapter implements EmployeeApiDelegate {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper mapper;

    public ResponseEntity<Employee> load(String id){
        log.info("Loading employee {}", id);
        return ResponseEntity.ok(
                mapper.mapToDto(employeeService.loadEmployee(id))
        );
    }
}
