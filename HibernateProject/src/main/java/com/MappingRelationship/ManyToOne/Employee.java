package com.MappingRelationship.ManyToOne;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "employee")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	public List<Laptop> getList() {
		return laptop;
	}

	public void setList(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
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
}
