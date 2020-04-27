/*This class is used to add,update and retrieve Block*/
package com.apartment.keerthi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.keerthi.entity.Apartment;
import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.service.IBlockService;

@RestController
public class BlockController {

	@Autowired
	IBlockService blockService;

	//This method is used to create block in the database .It takes a block type object
	@RequestMapping(value = "/CreateBlock",method = RequestMethod.POST)
	public ResponseEntity<Object> createBlock(@RequestBody Block block) {

		try {
			String status = blockService.createBlock(block);
			if("success".equalsIgnoreCase(status)) {
				return new ResponseEntity<>("Block is created successfully", HttpStatus.CREATED);

			}
			else {
				return new ResponseEntity<>("Problem in Block creation - Block Name Missing", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Block creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}
	}
	//This method is used to get block .It takes Id and returns the object if its present in the database
		@RequestMapping(value = "/{id}/getBlock",method = RequestMethod.GET)
		public ResponseEntity<Object> getBlock(@PathVariable("id")String id) {
			try {
				Block block = blockService.getBlock(id);
				if(block != null) {
				return new ResponseEntity<>(block, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>("Please make sure a Block is present with the given ID (ID should be a natural number)", HttpStatus.INTERNAL_SERVER_ERROR);
		
				}
			}
			catch(Exception e)
			{
				return new ResponseEntity<>("Problem in Block creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
			}
			
		}

	}
