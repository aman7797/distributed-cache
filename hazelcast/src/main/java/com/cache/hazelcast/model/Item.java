package com.cache.hazelcast.model;

import java.io.Serializable;

public class Item implements Serializable{

	private  int id;
	private String name;
	private String category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
}
