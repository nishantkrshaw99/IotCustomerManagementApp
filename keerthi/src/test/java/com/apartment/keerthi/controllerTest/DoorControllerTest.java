package com.apartment.keerthi.controllerTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.apartment.keerthi.controller.DoorController;
import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.serviceImpl.DoorService;

@RunWith(MockitoJUnitRunner.class)
public class DoorControllerTest {
	@InjectMocks
	DoorController doorController;

	@Mock
	DoorService doorService;

	@SuppressWarnings("deprecation")
	@Test
	public void createDoor()
	{
		Door door = new Door();
		door.setId(1);
		door.setFloorId(1);
		door.setDoorName("Door1");
		
		Mockito.when(doorService.createDoor(Mockito.any())).thenReturn("success");
		ResponseEntity<Object> result = doorController.createDoor(door);
		Assert.assertEquals("Door is created successfully", result.getBody());


	}
	@Test
	public void createDoorfailure()
	{
		Door door = new Door();
		door.setId(1);
		door.setFloorId(1);
		door.setDoorName("Door1");
		
		Mockito.when(doorService.createDoor(Mockito.any())).thenReturn("failure");
		ResponseEntity<Object> result = doorController.createDoor(door);
		Assert.assertEquals(500, result.getStatusCodeValue());


	}
	@Test
	public void getDoorTest()
	{
		Door door = new Door();
		door.setId(1);
		door.setFloorId(1);
		door.setDoorName("Door1");

		Mockito.when(doorService.getDoor("1")).thenReturn(door);
		ResponseEntity<Object> result = doorController.getDoor("1");
		Assert.assertEquals(door, result.getBody());
	}
	@Test
	public void getDoorFailureTest()
	{
		Door door = new Door();
		door.setId(1);
		door.setFloorId(1);
		door.setDoorName("Door1");

		Mockito.when(doorService.getDoor(Mockito.anyString())).thenReturn(null);
		ResponseEntity<Object> result = doorController.getDoor("O");
		Assert.assertEquals(500, result.getStatusCodeValue());
	}
}
