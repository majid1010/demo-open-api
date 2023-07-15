package my.examples.openapi.codegen.application.services;


import my.examples.openapi.codegen.application.domain.models.DomainEmployee;
import my.examples.openapi.codegen.application.domain.models.EmployeeStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
class EmployeeServiceImpl implements EmployeeService {
    private static final Map<String, DomainEmployee> repo = new ConcurrentHashMap<>(
            Map.of(
                    "emp01", new DomainEmployee("emp01", "Majid", "Daneshmandian", EmployeeStatus.HIRED, List.of()),
                    "emp02", new DomainEmployee("emp02", "Farzaneh", "Amiri", EmployeeStatus.HIRED, List.of())
            )
    );

    @Override
    public DomainEmployee loadEmployee(String id) {
        return repo.get(id);
    }

    @Override
    public DomainEmployee addEmployee(DomainEmployee employee) {
        return repo.put(employee.getId(), employee);
    }

    @Override
    public void deleteEmployee(String id) {
        repo.remove(id);
    }
}
