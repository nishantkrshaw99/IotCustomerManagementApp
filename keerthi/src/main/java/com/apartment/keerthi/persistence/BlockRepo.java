/*This interface is used to create the Block repository to execute queries to Block table*/
package com.apartment.keerthi.persistence;

import org.springframework.data.repository.CrudRepository;

import com.apartment.keerthi.entity.Block;

public interface BlockRepo extends CrudRepository<Block,String> {
	Block findById(int id);


}
