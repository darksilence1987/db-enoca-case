package com.example.dbenocacase.controller;

import com.example.dbenocacase.repository.entity.Company;
import com.example.dbenocacase.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// Rest API üzerinden browserdan /company adresine gelen istekleri yöneten sınıf
@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/byId")
    public ResponseEntity<String> getCompany(long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id).toString());
    }
    @GetMapping()
    public ResponseEntity<String> getAllCompany() {
        return ResponseEntity.ok(companyService.findAllCompany().toString());
    }
    @PutMapping()
    public ResponseEntity<String> updateCompany(@RequestParam Company company) {
        companyService.updateCompany(company);
        return ResponseEntity.ok(companyService.getCompanyById(company.getId()).toString());
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteCompany(long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Company deleted");
    }
    @PostMapping()
    public ResponseEntity<String> addCompany(@RequestParam String name, @RequestParam String address) {
        Company temp = new Company(name, address);
        temp = companyService.addCompany(temp);
        return ResponseEntity.ok(temp.toString());
    }
}
