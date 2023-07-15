package my.examples.openapi.codegen.controllers;

import my.examples.openapis.employee.client.ApiException;
import my.examples.openapis.employee.client.api.EmployeeApi;
import my.examples.openapis.employee.client.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("load-data")
public class EmployeeClientController {

    @Autowired
    EmployeeApi employeeApi;

    @GetMapping("{id}")
    Employee load(@PathVariable String id) throws ApiException {
        Employee e = employeeApi.load(id);
/*        Employee e = employeeApi.deleteEmployee(id);
        Employee e = employeeApi.add(e);*/
        return e;
    }

}
