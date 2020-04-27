/*This class is used to add,update and retrieve Floor*/
package com.apartment.keerthi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.service.IFloorService;

@RestController
public class FloorController {
	
	@Autowired
	IFloorService floorService;
	//This method is used to create Floor in the database .It takes a floor type object
	@RequestMapping(value = "/CreateFloor",method = RequestMethod.POST)
	public ResponseEntity<Object> createFloor(@RequestBody Floor floor) {
		System.out.println(floor.getId());
		System.out.println(floor.getFloorName());
		
		try {
			String status = floorService.createFloor(floor);
			if("success".equalsIgnoreCase(status)) {
				return new ResponseEntity<>("Floor is created successfully", HttpStatus.CREATED);

			}
			else {
				return new ResponseEntity<>("Problem in Floor creation - Floor Name Missing", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Floor creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}
		
		
	}
	//This method is used to get floor .It takes Id and returns the object if its present in the database
	@RequestMapping(value = "/{id}/getFloor",method = RequestMethod.GET)
	public ResponseEntity<Object> getFloor(@PathVariable("id")String id) {
		try {
			Floor floor = floorService.getFloor(id);
			if(floor != null) {
			return new ResponseEntity<>(floor, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Please make sure a Floor is present with the given ID (ID should be a natural number)", HttpStatus.INTERNAL_SERVER_ERROR);
	
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Floor creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}
	}
}
