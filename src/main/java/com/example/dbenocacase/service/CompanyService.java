package com.example.dbenocacase.service;

import com.example.dbenocacase.repository.ICompanyRepository;
import com.example.dbenocacase.repository.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final ICompanyRepository companyRepository;

    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(long id) {
        companyRepository.deleteById(id);
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }
}
