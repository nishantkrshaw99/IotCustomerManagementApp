/*This interface is used to make ApartmentService class loosely coupled with ApartmentController class */
package com.apartment.keerthi.service;

import com.apartment.keerthi.entity.Apartment;

public interface IApartmentService {
	
	public String createApartment(Apartment apartment);
	public Apartment getApartment(String id);
	public String deleteApartment(String id);
}
