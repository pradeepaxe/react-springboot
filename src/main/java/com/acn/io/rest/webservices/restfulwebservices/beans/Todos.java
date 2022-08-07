package com.acn.io.rest.webservices.restfulwebservices.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todos {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String description;
	private Date isDate;
	private boolean isDone;
	
	public Todos() {
		// TODO Auto-generated constructor stub
	}
	
	public Todos(long id, String username, String description, Date isDate, boolean isDone) {
		 
		this.id = id;
		this.username = username;
		this.description = description;
		this.isDate = isDate;
		this.isDone = isDone;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getIsDate() {
		return isDate;
	}
	public void setIsDate(Date isDate) {
		this.isDate = isDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "Todos [id=" + id + ", username=" + username + ", description=" + description + ", isDate=" + isDate
				+ ", isDone=" + isDone + "]";
	}


	
	
	
}
