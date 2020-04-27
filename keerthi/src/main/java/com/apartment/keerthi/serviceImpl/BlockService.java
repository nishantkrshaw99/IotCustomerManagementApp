/*This class is used to add, update and retrieve Block from and to database*/
package com.apartment.keerthi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.apartment.keerthi.entity.Apartment;
import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.persistence.BlockRepo;
import com.apartment.keerthi.service.IBlockService;

@Service
public class BlockService implements IBlockService {
	@Autowired
	BlockRepo blockRepo;
	
	//This method is used to create block in the database .It takes a block type object
	@Override
	public String createBlock(Block block) {
		// TODO Auto-generated method stub
		if(!(StringUtils.isEmpty(block.getBlockName())))
		{
			blockRepo.save(block);
			return "success";
		}
		else {
			return "failure";
		}

	}
	//This method is used to get block .It takes Id and returns the object if its present in the database
	@Override
	public Block getBlock(String id) {
		// TODO Auto-generated method stub
		
		try {
			if(!(StringUtils.isEmpty(id)))
			{
				int aid= Integer.parseInt(id);
				return blockRepo.findById(aid);
			}
			else {
				System.out.println("ID missing to get Block");
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in getBlock : "+ e.getMessage());
			return null;
		}
	}

	
}
