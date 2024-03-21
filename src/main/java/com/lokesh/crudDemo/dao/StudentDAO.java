package com.lokesh.crudDemo.dao;

import com.lokesh.crudDemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
}
