/*Block POJO + Table*/
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
import javax.persistence.OneToMany;

@Entity
public class Block {
	@Id
	@Column(name = "blockId")
	private int id;
	
	@Column(name = "apartmentId")
	private int apartmentId;

	 public int getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	private String blockName;
	public Block(int id, int apartmentId, String blockName) {
		super();
		this.id = id;
		this.blockName = blockName;
	}
	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(orphanRemoval=true,fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="blockId")
	private List<Floor> floor = new ArrayList<>();

	public List<Floor> getFloor() {
		return floor;
	}
	public void setFloor(List<Floor> floor) {
		this.floor = floor;
	}
	
}
