package employee.management.controller;

import employee.management.model.EmployeeData;
import employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/employee")
@RestController
public class EmployeeController{
    @Autowired
private EmployeeService employeeService;
// user get tha all of data
    @GetMapping()
    public List<EmployeeData> getAllEmployee(){
        return employeeService.getEmployee();
    }

///comments


    //    user create of the data in database;
    @PostMapping()
    public String createEmployee(@RequestBody EmployeeData employeeData){
     return employeeService.createEmployee(employeeData);
    }
//user update the data of database
    @PutMapping("{Id}")
    public String updateEmployee(@PathVariable Long Id, @RequestBody EmployeeData EmployeeDetail) {
        return employeeService.updateEmployee(Id,EmployeeDetail);
    }
// user delete the data of database
    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable long id){

        return employeeService.deleteEmployee(id);
    }
}
