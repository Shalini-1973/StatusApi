package com.shalini.status.api.model;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Comment")
public class Comment {

	@Transient
    public static final String SEQUENCE_NAME = "comment_sequence";
	
	@Id
	private long com_id;
	private String Comment;
	
	//@ManyToOne(targetEntity=Status.class, fetch=FetchType.LAZY)
	@DBRef
	@CascadeSave
	private Status status;
	
	private long user_id;

	public long getCom_id() {
		return com_id;
	}

	public void setCom_id(long com_id) {
		this.com_id = com_id;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	/*public Status getStatus() {
		return status;
	}*/

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public Comment(long com_id, String comment, Status status, long user_id) {
		super();
		this.com_id = com_id;
		Comment = comment;
		this.status = status;
		this.user_id = user_id;
	}

	public Comment() {
		
	}
	
	
}
