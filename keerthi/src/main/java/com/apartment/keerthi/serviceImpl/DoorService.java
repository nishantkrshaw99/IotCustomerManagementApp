/*This class is used to add, update and retrieve Door from and to database*/
package com.apartment.keerthi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.persistence.DoorRepo;
import com.apartment.keerthi.service.IDoorService;


@Service
public class DoorService implements IDoorService {

	@Autowired
	DoorRepo doorRepo;

	//This method is used to create door in the database .It takes a door type object
	@Override
	public String createDoor(Door door) {
		// TODO Auto-generated method stub

		if(!(StringUtils.isEmpty(door.getDoorName())))
		{
			doorRepo.save(door);
			return "success";
		}
		else {
			return "failure";
		}
	}
	//This method is used to getdoor .It takes Id and returns the object if its present in the database
	@Override
	public Door getDoor(String id) {
		// TODO Auto-generated method stub


		try {
			if(!(StringUtils.isEmpty(id)))
			{
				int aid= Integer.parseInt(id);
				return doorRepo.findById(aid);
			}
			else {
				System.out.println("ID missing to get Door");
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in getDoor : "+ e.getMessage());
			return null;

		}
	}
}
