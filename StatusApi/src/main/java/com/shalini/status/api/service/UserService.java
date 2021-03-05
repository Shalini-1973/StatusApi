package com.shalini.status.api.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shalini.status.api.model.Comment;
import com.shalini.status.api.model.Status;
import com.shalini.status.api.model.User;
import com.shalini.status.api.repository.CommentRepository;
import com.shalini.status.api.repository.StatusRepository;
import com.shalini.status.api.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository repository;

	@Autowired
	private StatusRepository statusRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return repository.findById(userId).get();
	}

	public void saveStatus(Status status) {
		statusRepo.save(status);
	}

	public void saveUser(User user) {
		repository.save(user);
	}

	public byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
		
	}

	public Status getStatusById(long statusId) {
		return statusRepo.findById(statusId).get();
	}

	public void saveComment(Comment com) {
		commentRepo.save(com);
	}

	public List<Status> findAll() {
		return statusRepo.findAll();
	}

	public List<Status> findByUser(User id) {
		return statusRepo.findByUser(id);
	}

	public User findUserById(long id) {
		return repository.findById(id).get();
	}
	
	

   
	
}
