/*This class is used to add, delete, update and retrieve Apartment from and to database*/

package com.apartment.keerthi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apartment.keerthi.entity.Apartment;
import com.apartment.keerthi.persistence.ApartmentRepo;
import com.apartment.keerthi.service.IApartmentService;

@Service
public class ApartmentService implements IApartmentService{

	@Autowired
	ApartmentRepo apartmentRepo;

	//This method is used to create apartment in the database .It takes an Apartment type object.
	@Override
	public String createApartment(Apartment apartment) {

		if(!(StringUtils.isEmpty(apartment.getName())))
		{
			apartmentRepo.save(apartment);
			return "success";
		}
		else {
			return "failure";
		}

	}
	//This method is used to get apartment .It takes Id and returns the object if its present in the database
	@Override
	public Apartment getApartment(String id) {
		try {
			if(!(StringUtils.isEmpty(id)))
			{
				int aid= Integer.parseInt(id);
				return apartmentRepo.findById(aid);
			}
			else {
				System.out.println("ID missing to get Apartment");
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in getApartment : "+ e.getMessage());
			return null;
		}

	}
	//This method is used to delete apartment .It takes Id and deletes the object if its present in the database
	@Override
	public String deleteApartment(String id) {
		// TODO Auto-generated method stub

		try {
			if(!(StringUtils.isEmpty(id)))
			{
				int aid= Integer.parseInt(id);
				Apartment apartment = apartmentRepo.findById(aid);
				if(apartment !=null) {
					apartmentRepo.deleteById(aid);
					return "success";
				}
				else {
					return "missing";
				}
				
			}
			else {
				System.out.println("ID missing to delete Apartment");
				return "missing";
			}
		}catch(Exception e){
			return "failure";
		}
	}

}

