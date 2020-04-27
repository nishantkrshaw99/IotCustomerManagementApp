/*Floor POJO + Table*/
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
public class Floor {
	@Id
	@Column(name = "floorId")
	private int id;
	private String floorName;
	
	@Column(name="blockId")
	private int blockId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public Floor(int id, String floorName, int blockId) {
		super();
		this.id = id;
		this.floorName = floorName;
		this.blockId = blockId;
	}

	public Floor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(orphanRemoval=true,fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="floorId")
	private List<Door> door = new ArrayList<>();

	public List<Door> getDoor() {
		return door;
	}
	public void setDoor(List<Door> door) {
		this.door = door;
	}
	
	
}
