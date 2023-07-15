package my.examples.openapi.codegen.application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEmployee {
    private String id;
    private String firstName;
    private String lastName;
    private EmployeeStatus status;
    private List<String> notes;
}
