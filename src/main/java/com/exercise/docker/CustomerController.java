package com.exercise.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerController {

    @Resource CustomerDao customerDaoService;

    @GetMapping
    public List<Customer> findAll(){
        return customerDaoService.findAll();
    }
}
