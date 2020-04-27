/*Door POJO + Table*/
package com.apartment.keerthi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Door {
	@Id
	@Column(name = "doorId")
	private int id;
	
	private String doorName;
	
	@Column(name = "floorId")
	private int floorId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoorName() {
		return doorName;
	}

	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public Door(int id, String doorName, int floorId) {
		super();
		this.id = id;
		this.doorName = doorName;
		this.floorId = floorId;
	}

	public Door() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
