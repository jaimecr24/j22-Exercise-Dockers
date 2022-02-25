package com.exercise.docker;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerid(rs.getString("customerid"));
        customer.setFirstName(rs.getString("firstname"));
        customer.setSurname(rs.getString("surname"));
        customer.setShipping_state(rs.getString("shipping_state"));
        return customer;
    }
}
