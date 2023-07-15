package my.examples.openapi.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Operation(summary = "Get an employee by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the employee",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @GetMapping("{id}")
    ResponseEntity<Employee> load(@PathVariable String id){
        return ResponseEntity.ok(new Employee());
    }

    @PostMapping
    ResponseEntity<Employee> add(@RequestBody Employee employee){
        employee.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(employee);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted the employee",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Employee cannot be deleted",
                    content = @Content) })
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable String id){
        return ResponseEntity.noContent().build();
    }

}
