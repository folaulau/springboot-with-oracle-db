package com.folautech.oracle.dataloader;

import com.folautech.oracle.dao.UserDAO;
import com.folautech.oracle.entity.Customer;
import com.folautech.oracle.entity.User;
import com.folautech.oracle.repository.CustomerRepository;
import com.folautech.oracle.repository.UserRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomerData {

    @Autowired
    private CustomerRepository customerRepository;

    private Faker faker = new Faker();

    @PostConstruct
    public void init() {
        System.out.println("CustomerData.init()");

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Customer customer = Customer.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .active(random.nextBoolean())
                    .comments(faker.lorem().paragraph(40))
                    .build();

            System.out.println("new customer: "+customer.toString());

            Customer savedCustomer = customerRepository.saveAndFlush(customer);

            System.out.println("savedCustomer: "+savedCustomer.toString());
        }

    }
}
