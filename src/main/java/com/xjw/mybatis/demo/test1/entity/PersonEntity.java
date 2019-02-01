package com.xjw.mybatis.demo.test1.entity;

import java.io.Serializable;

public class PersonEntity implements Serializable{
	private static final long serialVersionUID = -1138245964662330288L;
	
	private int id;
	private String name;
	
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
	
	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", name=" + name + "]";
	}
	
}
