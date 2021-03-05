package com.shalini.status.api.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Status")
public class Status {
	
	@Transient
    public static final String SEQUENCE_NAME = "status_sequence";
	
	
	@Id
	private long id;

	
	
	@Lob
	@Column(name = "file", columnDefinition = "LONGBLOB")
	private byte[] file; 
	
	//@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@DBRef
	@CascadeSave
	private User user;
	
	//@OneToMany(targetEntity=Comment.class,cascade=CascadeType.ALL, mappedBy="status")
	@DBRef
	@CascadeSave
	private List<Comment> comment;

	
/*	public byte[] getFile() {
		return file;
	}
*/
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	public void setFile(byte[] file) {
		this.file = file;
	}

/*	public User getUser() {
		return user;
	}
*/
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	
	

	

	

	public Status(long id, byte[] file, User user, List<Comment> comment) {
		super();
		this.id = id;
		this.file = file;
		this.user = user;
		this.comment = comment;
	}

	public Status(){}

}
