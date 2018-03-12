package com.learn.entity;

/**
 * Blog的实体类
 * @author sunwei
 *
 */
public class Blog {
	int id;
	String name;
	String email;
	
	public Blog() {
		super();
	}
	public Blog(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
