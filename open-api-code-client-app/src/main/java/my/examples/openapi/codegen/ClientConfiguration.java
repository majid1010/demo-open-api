package my.examples.openapi.codegen;

import my.examples.openapis.employee.client.ApiClient;
import my.examples.openapis.employee.client.api.EmployeeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public EmployeeApi employeeApi(@Value("${apis.employee-ms.base-url}") String employeeMsBaseUrl) {
        EmployeeApi employeeApi = new EmployeeApi();
        employeeApi.setCustomBaseUrl(employeeMsBaseUrl);
        return employeeApi;
    }

    @Bean
    public ApiClient employeeApiClient() {
        return new ApiClient();
    }
}
