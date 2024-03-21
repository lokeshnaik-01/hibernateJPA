package com.lokesh.crudDemo.dao;

import com.lokesh.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName asc", Student.class);
        // Student and firstName are from JSP
        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        // set query parameters
        theQuery.setParameter("theData", theLastName);
        // return result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // find student by id
        Student tempStudent = entityManager.find(Student.class, id);

        // remove the student
        entityManager.remove(tempStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
