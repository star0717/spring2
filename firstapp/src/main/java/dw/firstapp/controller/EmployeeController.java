package dw.firstapp.controller;

import dw.firstapp.model.Employee;
import dw.firstapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("api/employee/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("api/employee/{id}")
        public Employee updateEmployeeById(@PathVariable long id,
                                           @RequestBody Employee employee){
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("api/employee/{id}")
    public Employee deleteEmployeeById(@PathVariable long id){
        return employeeService.deleteEmployeeById(id);
    }
}
