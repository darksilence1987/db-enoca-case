package com.example.dbenocacase.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.dbenocacase.repository.entity.Company, Long>{
}
