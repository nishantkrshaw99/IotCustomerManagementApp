package com.apartment.keerthi.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.apartment.keerthi.entity.Apartment;
import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.persistence.BlockRepo;
import com.apartment.keerthi.serviceImpl.BlockService;

@RunWith(MockitoJUnitRunner.class)
public class BlockServiceTest {
	
	@InjectMocks
	BlockService blockService;
	
	@Mock
	BlockRepo blockRepo;
	
	@Test
	public void createBlockTest()
	{
		Block block = new Block();
		block.setId(1);
		block.setApartmentId(1);
		block.setBlockName("Block1");
		block.setFloor(getfloor());
		
		Mockito.when(blockRepo.save(block)).thenReturn(Mockito.any());
		String result = blockService.createBlock(block);
		Assert.assertEquals("success", result);

		
	}
	@Test
	public void createBlockFailureTest()
	{
		Block block = new Block();
		block.setId(1);
		block.setApartmentId(1);
		block.setBlockName("");
		block.setFloor(getfloor());
		
		String result = blockService.createBlock(block);
		Assert.assertEquals("failure", result);

		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getBlockTest()
	{
		Block block = new Block();
		block.setId(1);
		block.setApartmentId(1);
		block.setBlockName("Block1");
		block.setFloor(getfloor());
		
		Mockito.when(blockRepo.findById(1)).thenReturn(block);
		Block block1 = blockService.getBlock("1");
		Assert.assertEquals(block, block1);

		
	}

	private List<Floor> getfloor() {
		// TODO Auto-generated method stub
		List<Floor> floor = new ArrayList();
		Floor floor1 = new Floor();
		floor1.setId(1);
		floor1.setFloorName("Floor1");
		floor1.setBlockId(1);
		floor1.setDoor(getdoor());
		floor.add(floor1);
		return floor;
	}


	private List<Door> getdoor() {
		// TODO Auto-generated method stub
		List<Door> door = new ArrayList();
		Door door1 = new Door();
		door1.setId(1);
		door1.setFloorId(1);
		door1.setDoorName("Door1");
		door.add(door1);
		return door;
	}

}
