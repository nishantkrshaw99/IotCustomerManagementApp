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

import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.persistence.FloorRepo;
import com.apartment.keerthi.serviceImpl.FloorService;

@RunWith(MockitoJUnitRunner.class)
public class FloorServiceTest {
	@InjectMocks
	FloorService floorService;
	
	@Mock
	FloorRepo floorRepo;
	
	@Test
	public void createFloorTest()
	{
		Floor floor = new Floor();
		floor.setId(1);
		floor.setBlockId(1);
		floor.setFloorName("Floor1");
		floor.setDoor(getdoor());
		
		Mockito.when(floorRepo.save(floor)).thenReturn(Mockito.any());
		String result = floorService.createFloor(floor);
		Assert.assertEquals("success", result);

		
	}
	@Test
	public void createFloorFailureTest()
	{
		Floor floor = new Floor();
		floor.setId(1);
		floor.setBlockId(1);
		floor.setFloorName("");
		floor.setDoor(getdoor());
		
		String result = floorService.createFloor(floor);
		Assert.assertEquals("failure", result);

		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getFloorTest()
	{
		Floor floor = new Floor();
		floor.setId(1);
		floor.setBlockId(1);
		floor.setFloorName("Floor1");
		floor.setDoor(getdoor());
		
		Mockito.when(floorRepo.findById(1)).thenReturn(floor);
		Floor floor1 = floorService.getFloor("1");
		Assert.assertEquals(floor, floor1);

		
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
