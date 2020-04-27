package com.apartment.keerthi.controllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.apartment.keerthi.controller.BlockController;
import com.apartment.keerthi.entity.Apartment;
import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.serviceImpl.BlockService;

@RunWith(MockitoJUnitRunner.class)
public class BlockControllerTest {
	@InjectMocks
	BlockController blockController;

	@Mock
	BlockService blockService;

	@SuppressWarnings("deprecation")
	@Test
	public void createBlock()
	{
		Block block = new Block();
		block.setId(1);
		block.setApartmentId(1);
		block.setBlockName("Block1");
		block.setFloor(getfloor());

		Mockito.when(blockService.createBlock(Mockito.any())).thenReturn("success");
		ResponseEntity<Object> result = blockController.createBlock(block);
		Assert.assertEquals("Block is created successfully", result.getBody());


	}
	@Test
	public void createBlockfailure()
	{
		Block block = new Block();
		block.setId(1);
		block.setApartmentId(1);
		block.setBlockName("Block1");
		block.setFloor(getfloor());

		Mockito.when(blockService.createBlock(Mockito.any())).thenReturn("failure");
		ResponseEntity<Object> result = blockController.createBlock(block);
		Assert.assertEquals(500, result.getStatusCodeValue());


	}
	@Test
	public void getBlockTest()
	{
		Block block = new Block();
		block.setId(1);
		block.setApartmentId(1);
		block.setBlockName("Block1");
		block.setFloor(getfloor());

		Mockito.when(blockService.getBlock(Mockito.anyString())).thenReturn(block);
		ResponseEntity<Object> result = blockController.getBlock("1");
		Assert.assertEquals(block, result.getBody());
	}
	@Test
	public void getBlockFailureTest()
	{
		Block block = new Block();
		block.setId(1);
		block.setApartmentId(1);
		block.setBlockName("Block1");
		block.setFloor(getfloor());

		Mockito.when(blockService.getBlock(Mockito.anyString())).thenReturn(null);
		ResponseEntity<Object> result = blockController.getBlock("O");
		Assert.assertEquals(500, result.getStatusCodeValue());
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
