package employee.management.service;

import employee.management.model.EmployeeData;
import employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService{
 @Autowired
    private EmployeeRepository employeeRepository;

// return the list of data
    public List<EmployeeData> getEmployee(){
        return employeeRepository.findAll();
    }





    public String createEmployee(EmployeeData employeeData) {
        EmployeeData employee = new EmployeeData();
        employee.setEmployeeId(employeeData.getEmployeeId());
        employee.setEmployeeName(employeeData.getEmployeeName());
        employee.setEmployeeEmail(employeeData.getEmployeeEmail());
        employee.setEmployeeSalary(employeeData.getEmployeeSalary());
        employee.setEmployeeRole(employeeData.getEmployeeRole());
        employeeRepository.save(employeeData);
        return "Success";
    }

    public String updateEmployee(Long id, EmployeeData employeeDetail) {
        Optional<EmployeeData> employee = employeeRepository.findById(id);
        String employeeEmail = employee.get().getEmployeeEmail();
        employeeEmail = "pawankumar957654@gmail.com";
        employee.get().setEmployeeEmail(employeeEmail);
        employeeRepository.save(employee.get());
        return "update Successfully";
    }

    public String deleteEmployee(long id){
        Optional<EmployeeData> employee = employeeRepository.findById(id);
       employeeRepository.delete(employee.get());
        return "deleted Successfully";
    }


    public List<EmployeeData> getAllReturnBySalary(Double salary){
        List<EmployeeData> emp = employeeRepository.findAll();
        List<EmployeeData> emp2 = new ArrayList<>();
        for (int i = 0; i < emp.size(); i++) {
            if (salary > 55000.00 && emp.get(i).getEmployeeSalary() >55000.00) {
                emp2.add(emp.get(i));
            }
        }
        return emp2;
    }
}
