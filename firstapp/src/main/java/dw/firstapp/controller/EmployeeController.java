package dw.firstapp.controller;

import dw.firstapp.model.Employee;
import dw.firstapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    // 의존성주입
//    @Autowired
    EmployeeService employeeService;
    @Autowired // 생성자주입 (권장방법)
    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping("/api/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        // Service
        return employeeService.saveEmployee(employee);
    } // 필드 주입

    @GetMapping("api/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
