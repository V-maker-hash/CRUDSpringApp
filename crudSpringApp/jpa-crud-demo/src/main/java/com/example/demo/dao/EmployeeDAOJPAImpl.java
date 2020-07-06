package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        Query query = entityManager.createQuery("from Employee");

        //execute query and get result list
        List<Employee> employees = query.getResultList();

        //return the results

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        Employee employee = entityManager.find(Employee.class, theId);

        return employee;
    }

    @Override
    public void save(Employee theEmployee) {

        Employee employee = entityManager.merge(theEmployee);
        theEmployee.setId(employee.getId());
    }

    @Override
    public void deleteById(int theId) {

        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", theId);

    }
}
