package com.example.SWE645Assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SWE645Assignment3.model.*;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
