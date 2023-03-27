package com.example.demoToday.templateDao;

import com.example.demoToday.model.Emp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper<Emp> {


    public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
        Emp employee = new Emp();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setGender(resultSet.getString("gender"));
        employee.setSubject(resultSet.getString("subject"));
        employee.setDate(resultSet.getString("date"));
        return employee;
    }
}
