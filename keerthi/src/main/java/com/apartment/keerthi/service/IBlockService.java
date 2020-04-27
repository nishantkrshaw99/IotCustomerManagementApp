/*This interface is used to make BloclService class loosely coupled with BlockController class */
package com.apartment.keerthi.service;

import com.apartment.keerthi.entity.Block;

public interface IBlockService {
	
	public String createBlock(Block block);
	public Block getBlock(String id);

}
