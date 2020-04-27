/*Apartment POJO + Table*/
package com.apartment.keerthi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Apartment {
	@Id
	@Column(name = "apartmentId")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToMany(orphanRemoval=true,fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="apartmentId")
	private List<Block> block = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Block> getBlock() {
		return block;
	}
	public void setBlock(List<Block> block) {
		this.block = block;
	}
	private String name;
	
	public Apartment(int id, String name, List<Block> block) {
		super();
		this.id = id;
		this.name = name;
		this.block = block;
	}
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Apartment [id=" + id + ", name=" + name + ", block=" + block + "]";
	} 
	
}