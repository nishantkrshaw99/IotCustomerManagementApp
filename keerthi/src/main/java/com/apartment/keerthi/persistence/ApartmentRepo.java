/*This interface is used to create the Apartment repository to execute queries to Apartment table*/
package com.apartment.keerthi.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.apartment.keerthi.entity.Apartment;

public interface ApartmentRepo extends CrudRepository<Apartment,String> {

	Apartment findById(int aid);

	void deleteById(int aid);


}
