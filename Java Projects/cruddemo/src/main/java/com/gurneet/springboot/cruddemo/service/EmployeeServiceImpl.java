package com.gurneet.springboot.cruddemo.service;

import com.gurneet.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gurneet.springboot.cruddemo.dao.EmployeeDAO;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDao;

    @Autowired
    public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO){
        employeeDao = theEmployeeDAO;
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDao.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);
    }
}
