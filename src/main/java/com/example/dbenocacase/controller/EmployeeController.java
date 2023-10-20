package com.example.dbenocacase.controller;

import com.example.dbenocacase.repository.entity.Company;
import com.example.dbenocacase.repository.entity.Employee;
import com.example.dbenocacase.service.CompanyService;
import com.example.dbenocacase.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Rest API üzerinden browserdan /employee adresine gelen istekleri yöneten sınıf
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    @GetMapping("/byId")
    public ResponseEntity<String> getEmployee(long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id).toString());
    }
    @GetMapping()
    public ResponseEntity<String> getAllEmployee() {
        return ResponseEntity.ok(employeeService.findAllEmployee().toString());
    }
    @PutMapping()
    public ResponseEntity<String> updateEmployee(@RequestParam Employee employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employeeService.getEmployeeById(employee.getId()).toString());
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteEmployee(long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }
    @PostMapping()
    public ResponseEntity<String> addEmployee(@RequestParam String address, @RequestParam long companyId, @RequestParam String email, @RequestParam String name, @RequestParam String phoneNumber, @RequestParam double salary, @RequestParam String surname) {
        Employee temp = new Employee(
                name,
                surname,
                email,
                address,
                phoneNumber,
                salary,
                companyService.getCompanyById(companyId)
        );
        temp = employeeService.addEmployee(temp);
        return ResponseEntity.ok(temp.toString());
    }
}
