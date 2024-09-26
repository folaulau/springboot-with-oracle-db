package com.folautech.oracle;

import com.folautech.oracle.dao.UserDAO;
import com.folautech.oracle.entity.User;
import com.folautech.oracle.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class SpringbootWithOracleDbApplicationTests {

	@Autowired
	private UserRepository userRepository;

	private Faker faker = new Faker();

	@Autowired
	private UserDAO userDAO;

	@Test
	void loadUsers() {

		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			User user = User.builder()
					.id(userDAO.getNexPersonalKey())
					.name(faker.name().fullName())
					.email(faker.internet().emailAddress())
					.active(random.nextBoolean())
					.age(random.nextInt(100))
					.salary(random.nextDouble())
					.heightInFt(random.nextFloat())
					.comments(faker.lorem().paragraph(40))
					.build();
			User savedUser = userRepository.saveAndFlush(user);

			System.out.println("savedUser: "+savedUser.toString());
		}
	}

}
