package dw.wholesale_company.service;

import dw.wholesale_company.model.Employee;
import dw.wholesale_company.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }




    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByHireLatest() {
        return employeeRepository.findAll()
                .stream().filter(e->e.getPosition().equals("사원") )
                .sorted(Comparator.comparing(Employee::getHireDate).reversed())
                .findFirst().get();
    }
}
