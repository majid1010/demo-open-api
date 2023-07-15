package my.examples.openapi.codegen;

import my.examples.openapis.employee.server.EmployeeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "my.examples")
@Import({ EmployeeConfiguration.class })
@SpringBootApplication
public class OpenApiCodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenApiCodeGenApplication.class, args);
	}

}
