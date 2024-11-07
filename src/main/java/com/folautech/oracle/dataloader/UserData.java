package com.folautech.oracle.dataloader;

import com.folautech.oracle.dao.UserDAO;
import com.folautech.oracle.entity.User;
import com.folautech.oracle.repository.UserRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UserData {

    @Autowired
    private UserRepository userRepository;

    private Faker faker = new Faker();

    @Autowired
    private UserDAO userDAO;

    @PostConstruct
    public void init() {
        System.out.println("UserData.init()");

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .active(random.nextBoolean())
                    .age(random.nextInt(100))
                    .salary(random.nextDouble())
                    .heightInFt(random.nextFloat())
                    .personalKey(userDAO.getNexPersonalKey())
                    .comments(faker.lorem().paragraph(40))
                    .build();

            System.out.println("new user: "+user.toString());

            User savedUser = userRepository.saveAndFlush(user);

            System.out.println("savedUser: "+savedUser.toString());
        }

    }
}
