package com.shalini.status.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shalini.status.api.model.User;
import com.shalini.status.api.repository.UserRepository;
import com.shalini.status.api.service.SequenceGeneratorService;


@SpringBootTest
class StatusApiApplicationTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void sendUser() {
		User user1 =new User();
		User user2 =new User();
		
		user1.setName("Ashu");
		user1.setMobile("7896541230");
		user1.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		user2.setName("PAshu");
		user2.setMobile("4596541230");

		user2.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		repo.save(user1);
		repo.save(user2);
		
		
	}
	
	
	
}
