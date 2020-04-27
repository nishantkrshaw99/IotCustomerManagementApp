/*This interface is used to make DoorService class loosely coupled with DoorController class */
package com.apartment.keerthi.service;

import com.apartment.keerthi.entity.Door;

public interface IDoorService {


	public String createDoor(Door door);
	public Door getDoor(String id);

}
