package com.example.demoToday.service;

import com.example.demoToday.model.Emp;
import com.example.demoToday.templateDao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {


    @Autowired
    EmpDao empDao;

    public void saveEms(Emp emp) {

        if (emp.getId() == null) {
            empDao.save(emp);
        } else {
            empDao.updatePerson(emp);
        }
    }


    public List<Emp> getUser() {
        return empDao.findAll();
    }

    public void deleteUser(Long id) {
        empDao.deleteById(id);
    }

    public Emp getUser(Long id) {
        return empDao.findById(id).orElse(new Emp());
    }

}
