package employee.management.controllertest;

import employee.management.controller.EmployeeController;
import employee.management.model.EmployeeData;
import employee.management.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest{



    @Mock
    private EmployeeService employeeServiceTest;

    @InjectMocks
    private EmployeeController employeeControllerTest;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllEmployee() {
//        mock
        List<EmployeeData> employeeData = new ArrayList<>();
        employeeData.add(new EmployeeData(1L,"pawan","kuarrrr@gmail.com",897665,"java"));
        employeeData.add(new EmployeeData(2L,"pawan","email@gmail.com",908876.00d,"javadevloper"));

        // Mocking
        when(employeeServiceTest.getEmployee()).thenReturn(employeeData);

        // Call the controller method
        List<EmployeeData> actualEmployeeList = employeeControllerTest.getAllEmployee();

        // Verify the result
        assertEquals(employeeData, actualEmployeeList);
    }
    @Test
    public void testCreateEmployee() {
        // Mocking data
        EmployeeData employeeData = new EmployeeData();
        employeeData.setEmployeeName("Aman");
        employeeData.setEmployeeEmail("Pravisht@example.com");
        employeeData.setEmployeeSalary(50000.0);
        employeeData.setEmployeeRole("Java Developer");

        //  behavior of employeeService
        when(employeeServiceTest.createEmployee(any(EmployeeData.class))).thenReturn("Success");

//       calling the controller method
        String result = employeeControllerTest.createEmployee(employeeData);

        // Verifying the result
        assertEquals("Success", result);
    }
    @Test
    public void testUpdateEmployee() {
        // Mocking
        Long employeeId = 1L;
        EmployeeData employeeData = new EmployeeData();
//        employeeData.setEmployeeName("Aman");
//        employeeData.setEmployeeEmail("Pravisht@example.com");
//        update the employeeSalary;
        employeeData.setEmployeeSalary(60000.0);
//        employeeData.setEmployeeRole("Java Developer");
        when(employeeServiceTest.updateEmployee(any(Long.class), any(EmployeeData.class)))
                .thenReturn("updated Successfully");
        String result = employeeControllerTest.updateEmployee(employeeId, employeeData);
        assertEquals("updated Successfully", result);
    }
    @Test
    public void testDeleteEmployee() {
        // Mocking data
        long employeeId = 1L;

        //  behavior of employeeService
        when(employeeServiceTest.deleteEmployee(anyLong())).thenReturn("deleted successfully");

        // Calling the controller method
        String result = employeeControllerTest.deleteEmployee(employeeId);

        // Verifying the result
        assertEquals("deleted successfully", result);
    }

}
