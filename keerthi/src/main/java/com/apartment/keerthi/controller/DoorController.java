/*This class is used to add,update and retrieve Door*/
package com.apartment.keerthi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.service.IDoorService;



@RestController
public class DoorController {

	@Autowired
	IDoorService doorService;

	//This method is used to create door in the database .It takes a door type object
	@RequestMapping(value = "/CreateDoor",method = RequestMethod.POST)
	public ResponseEntity<Object> createDoor(@RequestBody Door door) {
		System.out.println(door.getId());
		System.out.println(door.getDoorName());
		try {
			String status = doorService.createDoor(door);
			if("success".equalsIgnoreCase(status)) {
				return new ResponseEntity<>("Door is created successfully", HttpStatus.CREATED);

			}
			else {
				return new ResponseEntity<>("Problem in Door creation - Door Name Missing", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Door creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}

	}
	//This method is used to getdoor .It takes Id and returns the object if its present in the database
	@RequestMapping(value = "/{id}/getDoor",method = RequestMethod.GET)
	public ResponseEntity<Object> getDoor(@PathVariable("id")String id) {

		try {
			Door door = doorService.getDoor(id);
			if(door != null) {
			return new ResponseEntity<>(door, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Please make sure a Door is present with the given ID (ID should be a natural number)", HttpStatus.INTERNAL_SERVER_ERROR);
	
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Door creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}
	}
}
