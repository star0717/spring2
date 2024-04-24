package dw.wholesale_company.controller;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Department;
import dw.wholesale_company.service.CustomerService;
import dw.wholesale_company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }
}
