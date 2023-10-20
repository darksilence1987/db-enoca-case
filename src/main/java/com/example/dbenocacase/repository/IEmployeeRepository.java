package com.example.dbenocacase.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.dbenocacase.repository.entity.Employee, Long>{
}
