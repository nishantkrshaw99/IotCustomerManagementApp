/*This interface is used to create the Door repository to execute queries to Door table*/
package com.apartment.keerthi.persistence;

import org.springframework.data.repository.CrudRepository;

import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.entity.Floor;


public interface DoorRepo extends CrudRepository<Door,String> {
	Door findById(int id);
}
