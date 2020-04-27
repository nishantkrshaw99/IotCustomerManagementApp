/*This interface is used to make DoorService class loosely coupled with DoorController class */
package com.apartment.keerthi.service;

import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.entity.Floor;

public interface IFloorService {

	public String createFloor(Floor floor);

	public Floor getFloor(String id);

}
