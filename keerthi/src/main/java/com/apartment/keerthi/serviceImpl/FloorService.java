/*This class is used to add,update and retrieve Floor to and from database*/
package com.apartment.keerthi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.persistence.FloorRepo;
import com.apartment.keerthi.service.IFloorService;

@Service
public class FloorService implements IFloorService {

	@Autowired
	FloorRepo floorRepo;
	
	//This method is used to create Floor in the database .It takes a floor type object
	@Override
	public String createFloor(Floor floor) {
		// TODO Auto-generated method stub
		if(!(StringUtils.isEmpty(floor.getFloorName())))
		{
			floorRepo.save(floor);
			return "success";
		}
		else {
			return "failure";
		}
	}

	//This method is used to get floor .It takes Id and returns the object if its present in the database
	@Override
	public Floor getFloor(String id) {
		// TODO Auto-generated method stub

		try {
			if(!(StringUtils.isEmpty(id)))
			{
				int aid= Integer.parseInt(id);
				return floorRepo.findById(aid);
			}
			else {
				System.out.println("ID missing to get Floor");
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in getFloor : "+ e.getMessage());
			return null;

		}

	}
}
