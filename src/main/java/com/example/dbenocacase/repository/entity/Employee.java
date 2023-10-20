package com.example.dbenocacase.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tblemployee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    long id;
    @Column(name = "name", length = 50)
    String name;
    @Column(name = "surname", length = 50)
    String surname;
    @Column(name = "email", length = 50)
    String email;
    @Column(name = "address", length = 300)
    String address;
    @Column(name = "phone_number", length = 50)
    String phoneNumber;
    @Column(name = "salary")
    double salary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    Company company;

    public Employee(String name, String surname, String email, String address, String phoneNumber, double salary, Company company) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.company = company;
    }
}
