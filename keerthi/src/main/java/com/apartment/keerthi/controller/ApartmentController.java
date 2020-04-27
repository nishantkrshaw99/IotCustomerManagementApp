/*This class is used to add,delete,update and retrieve Apartment*/
package com.apartment.keerthi.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.keerthi.entity.Apartment;
import com.apartment.keerthi.service.IApartmentService;

@Transactional
@RestController
public class ApartmentController {

	@Autowired
	IApartmentService apartmentService;

	//This method is used to create apartment in the database .It takes an Apartment type object.
	@RequestMapping(value = "/CreateApartment",method = RequestMethod.POST)
	public ResponseEntity<Object> createApartment(@RequestBody Apartment apartment) {
		System.out.println(apartment.getId());
		System.out.println(apartment.getName());
		try {
			String status = apartmentService.createApartment(apartment);
			if("success".equalsIgnoreCase(status)) {
				return new ResponseEntity<>("Apartment is created successfully", HttpStatus.CREATED);

			}
			else {
				return new ResponseEntity<>("Problem in Apartment creation - Apartment Name Missing", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Apartment creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}

	}
	//This method is used to get apartment .It takes Id and returns the object if its present in the database
	@RequestMapping(value = "/{id}/getApartment",method = RequestMethod.GET)
	public ResponseEntity<Object> getApartment(@PathVariable("id")String id) {
		try {
			Apartment apartment = apartmentService.getApartment(id);
			if(apartment != null) {
				return new ResponseEntity<>(apartment, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Please make sure an Apartment is present with the given ID (ID should be a natural number)", HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Apartment creation", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}
	}
	//This method is used to delete apartment .It takes Id and deletes the object if its present in the database
	@RequestMapping(value = "/{id}/deleteApartment", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteApartment(@PathVariable("id") String id) { 
		try {
			String status = apartmentService.deleteApartment(id);
			if("success".equalsIgnoreCase(status)) {
				return new ResponseEntity<>("Apartment is deleted successfully", HttpStatus.CREATED);
			}
			else if("missing".equalsIgnoreCase(status)) {
				return new ResponseEntity<>("Please give valid Apartment ID or the apartment does not exist", HttpStatus.INTERNAL_SERVER_ERROR); 	
			}
			else  {
				return new ResponseEntity<>("Problem in Apartment deletion ", HttpStatus.INTERNAL_SERVER_ERROR); 	
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Problem in Apartment deletion", HttpStatus.INTERNAL_SERVER_ERROR); 	
		}
	}
}

