package com.lokesh.crudDemo.dao;

import com.lokesh.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{
    /// define field for entity manager

    // JPA Entity Manager and Data Source are automatically created by Spring Boot
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        // injecting the EntityManager
        System.out.println("Constructor in DAO Impl " + entityManager);
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    // for read, we do not need @Transactional as we aren't writing to db
    public Student findById(Integer id) {
        // pass the class and the primary key
        Student tempStudent = entityManager.find(Student.class, id);
        return tempStudent;
    }
}
