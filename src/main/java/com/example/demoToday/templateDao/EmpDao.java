package com.example.demoToday.templateDao;

import com.example.demoToday.model.Emp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
@Component
public class EmpDao {


    JdbcTemplate jdbcTemplate;

        public EmpDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final String SQL_FIND_EMPLOYEE = "select * from emps where id = ?";
    private final String SQL_DELETE_EMPLOYEE = "delete from emps where id = ?";
    private final String SQL_UPDATE_EMPLOYEE = "update emps set name = ?, gender = ?, subject = ?, date = ? where id = ?";
    private final String SQL_GET_ALL = "select * from emps";
    private final String SQL_INSERT_EMPLOYEE = "insert into emps( name, gender, subject, date ) values( ?,?,?,? )";


    public Optional<Emp> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[]{id}, new EmpMapper()));
    }

    public List<Emp> findAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new EmpMapper());
    }

    public boolean deleteById(Long id) {
        return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, id) > 0;
    }

    public boolean updatePerson(Emp employee) {
        return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getName(), employee.getGender(), employee.getSubject(), employee.getDate(), employee.getId()) > 0;
    }

    public boolean save(Emp employee) {
        return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getName(), employee.getGender(), employee.getSubject(), employee.getDate() ) > 0;
    }


}
