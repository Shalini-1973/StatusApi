package com.shalini.status.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shalini.status.api.dto.CommentDto;
import com.shalini.status.api.dto.StatusListDto;
import com.shalini.status.api.model.Comment;
import com.shalini.status.api.model.Status;
import com.shalini.status.api.model.User;
import com.shalini.status.api.service.SequenceGeneratorService;
import com.shalini.status.api.service.UserService;

@RestController
public class StatusController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	
	@PostMapping("/createStatus")
	public ResponseEntity<User> createStatus(@RequestParam("userId") String id,@RequestParam("Describe") String Describe, @RequestParam("file") MultipartFile file ) throws IOException {
		
		Status status = new Status();
		status.setId(sequenceGeneratorService.generateSequence(Status.SEQUENCE_NAME));
		status.setFile(service.compressBytes(file.getBytes()));
		User user = service.getUser(Integer.parseInt(id));
		status.setUser(user);
		status.setUser(user);
		service.saveStatus(status);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/comment")
	public ResponseEntity<Comment> comment(@RequestBody CommentDto commentDto) {
		Comment com =new Comment();
		com.setCom_id(sequenceGeneratorService.generateSequence(Comment.SEQUENCE_NAME));
		com.setComment(commentDto.getComment());
		com.setUser_id(commentDto.getUser_id());
		Status status=service.getStatusById(commentDto.getStatusId());
		//System.out.println(status.toString());
		//service.saveStatus(status);
		com.setStatus(status);
		service.saveComment(com);
		return ResponseEntity.ok(com);
		
	}
	
	
	@PostMapping("/listStatus")
	public ResponseEntity listStatus(@RequestBody StatusListDto listDto){
		
		long id = listDto.getUserId();
		User user = service.findUserById(id);
		List<Status> list = service.findByUser(user);
		int pageSize=listDto.getPageSize();
		int pageNo=listDto.getPageNumber();
		List<List<Status>> listOflist=new ArrayList<List<Status>>();
		int totalPage;
		if(pageSize%2==0) {
		totalPage=list.size()/pageSize;
		}else {
		totalPage=list.size()/pageSize+1;
		}
		int i=0;
		int j=0;
		while(i<totalPage) {
			int k=0;
			List<Status> sub_list=new ArrayList<>();
			while(k<pageSize && j<list.size()) {
				sub_list.add(list.get(j));
				j++;
				k++;
			}
			listOflist.add(sub_list);
			i++;
		}
		
		if((pageNo-1)<listOflist.size()) {
			return ResponseEntity.ok(listOflist.get(pageNo-1));
		}
		
		return ResponseEntity.ok("page number not available");
	}

}
