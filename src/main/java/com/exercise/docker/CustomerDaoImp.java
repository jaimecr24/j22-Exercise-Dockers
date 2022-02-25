package com.exercise.docker;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao {

    NamedParameterJdbcTemplate template;

    public CustomerDaoImp(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Customer> findAll() {
        return template.query("select * from customers;", new CustomerMapper());
    }

}
