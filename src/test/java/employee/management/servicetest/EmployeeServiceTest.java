package employee.management.servicetest;

import employee.management.model.EmployeeData;
import employee.management.repository.EmployeeRepository;
import employee.management.service.EmployeeService;
import jakarta.transaction.TransactionScoped;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;



public class EmployeeServiceTest{


        @Mock
        private EmployeeRepository employeeRepositoryTest;

        @InjectMocks
        private EmployeeService employeeServiceTest;


            @BeforeEach
            void beforeEach(){
                MockitoAnnotations.initMocks(this);
            }




@Test
    public void testGetEmployee() {
        // Mocking data
        List<EmployeeData> employeeData = new ArrayList<>();
       employeeData.add(new EmployeeData(1L, "John Doe", "john@example.com", 50000.0, "Developer"));
        employeeData.add(new EmployeeData(2L, "Jane Smith", "jane@example.com", 60000.0, "Manager"));

        // Mocking behavior of employeeRepository
        when(employeeRepositoryTest.findAll()).thenReturn(employeeData);

        // Calling the service method
        List<EmployeeData> result = employeeServiceTest.getEmployee();

        // Verifying the result
        assertEquals(2, result.size()); // Ensure correct number of employees returned
    }
    @Test
    public void testCreateEmployee() {
        // Mocking data
        EmployeeData employeeData = new EmployeeData();

        employeeData.setEmployeeName("Aman");
        employeeData.setEmployeeEmail("Pravisht@example.com");
        employeeData.setEmployeeSalary(50000.0);
        employeeData.setEmployeeRole("Java Developer");

        // Mocking behavior of employeeRepository
        when(employeeRepositoryTest.save(any(EmployeeData.class))).thenReturn(employeeData);

        // Calling the service method
        String result = employeeServiceTest.createEmployee(employeeData);

        // Verifying the result
        assertEquals("Success", result); // Ensure method returns "Success"

        // Verify that employeeRepository.save() is called with the correct parameter
        verify(employeeRepositoryTest, times(1)).save(employeeData);
    }
@Test
    public void testUpdateEmployee() {
        // Mocking data
        Long employeeId = 1L;
        EmployeeData employeeData = new EmployeeData();
        employeeData.setEmployeeEmail("pawankumar957654@gmail.com");

        // Mocking behavior of employeeRepository
        EmployeeData existingEmployee = new EmployeeData();
        existingEmployee.setEmployeeEmail("Kumar@gmail.com");
        Optional<EmployeeData> optionalEmployee = Optional.of(existingEmployee);
        when(employeeRepositoryTest.findById(employeeId)).thenReturn(optionalEmployee);
        when(employeeRepositoryTest.save(any(EmployeeData.class))).thenReturn(employeeData);

        // Calling the service method
        String result = employeeServiceTest.updateEmployee(employeeId, employeeData);

        // Verifying the result
        assertEquals("update Successfully", result); // Ensure method returns "update Successfully"

        // Verify that employeeRepository.save() is called with the correct parameter
        verify(employeeRepositoryTest, times(1)).save(existingEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        // Mocking data
        long employeeId = 1L;

        // Mocking behavior of employeeRepository
        EmployeeData employeeData = new EmployeeData();
        Optional<EmployeeData> optionalEmployee = Optional.of(employeeData);
        when(employeeRepositoryTest.findById(employeeId)).thenReturn(optionalEmployee);

        // Calling the service method
        String result = employeeServiceTest.deleteEmployee(employeeId);

        // Verifying the result
        assertEquals("deleted Successfully", result); // Ensure method returns "deleted Successfully"

        // Verify that employeeRepository.delete() is called with the correct parameter
        verify(employeeRepositoryTest, times(1)).delete(employeeData);
    }

}
