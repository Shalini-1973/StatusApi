package com.shalini.status.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shalini.status.api.model.Status;
import com.shalini.status.api.model.User;

@Repository
public interface StatusRepository extends MongoRepository<Status, Long> {
	List<Status> findByUser(User user);
}
