package com.puja.reactSpringbootfullstack.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String username;
        private String role;
        private String password;
}
