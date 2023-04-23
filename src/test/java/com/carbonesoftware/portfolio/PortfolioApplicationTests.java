package com.carbonesoftware.portfolio;

import com.carbonesoftware.portfolio.entity.User;
import com.carbonesoftware.portfolio.repository.AuthRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PortfolioApplicationTests {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private AuthRepository authRepo;

	@Test
	void contextLoads() {
		User adminUser = new User();
		adminUser.setEmail("diegocarbone22@gmail.com");
		adminUser.setPassword(this.encoder.encode("Asdasd123!"));
		this.authRepo.save(adminUser);
	}

}
