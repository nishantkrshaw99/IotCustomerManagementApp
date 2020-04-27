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

import com.apartment.keerthi.controller.FloorController;
import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.serviceImpl.FloorService;

@RunWith(MockitoJUnitRunner.class)
public class FloorControllerTest {

	@InjectMocks
	FloorController floorController;

	@Mock
	FloorService floorService;

	@SuppressWarnings("deprecation")
	@Test
	public void createFloor()
	{
		Floor floor = new Floor();
		floor.setId(1);
		floor.setBlockId(1);
		floor.setFloorName("Floor1");
		floor.setDoor(getdoor());
		
		Mockito.when(floorService.createFloor(Mockito.any())).thenReturn("success");
		ResponseEntity<Object> result = floorController.createFloor(floor);
		Assert.assertEquals("Floor is created successfully", result.getBody());


	}
	@Test
	public void createFloorfailure()
	{
		Floor floor = new Floor();
		floor.setId(1);
		floor.setBlockId(1);
		floor.setFloorName("Floor1");
		floor.setDoor(getdoor());
		
		Mockito.when(floorService.createFloor(Mockito.any())).thenReturn("failure");
		ResponseEntity<Object> result = floorController.createFloor(floor);
		Assert.assertEquals(500, result.getStatusCodeValue());


	}
	@Test
	public void getFloorTest()
	{
		Floor floor = new Floor();
		floor.setId(1);
		floor.setBlockId(1);
		floor.setFloorName("Floor1");
		floor.setDoor(getdoor());

		Mockito.when(floorService.getFloor("1")).thenReturn(floor);
		ResponseEntity<Object> result = floorController.getFloor("1");
		Assert.assertEquals(floor, result.getBody());
	}
	@Test
	public void getFloorFailureTest()
	{
		Floor floor = new Floor();
		floor.setId(1);
		floor.setBlockId(1);
		floor.setFloorName("Floor1");
		floor.setDoor(getdoor());

		Mockito.when(floorService.getFloor(Mockito.anyString())).thenReturn(null);
		ResponseEntity<Object> result = floorController.getFloor("O");
		Assert.assertEquals(500, result.getStatusCodeValue());
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
