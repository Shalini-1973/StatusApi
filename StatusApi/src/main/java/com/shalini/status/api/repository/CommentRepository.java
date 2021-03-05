package com.shalini.status.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shalini.status.api.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Long> {

}
