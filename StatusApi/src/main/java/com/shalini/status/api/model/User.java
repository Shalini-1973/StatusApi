package com.shalini.status.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="User")
public class User {

	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	
	@Id
	private long id;
	private String name;
	private String mobile;
	
	//@OneToMany(targetEntity=Status.class,cascade=CascadeType.ALL,mappedBy="user")
	@DBRef
	@CascadeSave
	private List<Status> status;

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}
	
	
	
	public User(long id, String name, String mobile, List<Status> status) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.status = status;
	}

	public User() {}
}
