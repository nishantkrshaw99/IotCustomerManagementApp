/*This interface is used to create the Floor repository to execute queries to Floor table*/
package com.apartment.keerthi.persistence;

import org.springframework.data.repository.CrudRepository;

import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.entity.Floor;

public interface FloorRepo extends CrudRepository<Floor,String> {
	Floor findById(int id);
}
