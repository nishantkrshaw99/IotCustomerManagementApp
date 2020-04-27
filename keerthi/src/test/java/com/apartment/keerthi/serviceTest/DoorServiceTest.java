package com.apartment.keerthi.serviceTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.persistence.DoorRepo;
import com.apartment.keerthi.serviceImpl.DoorService;

@RunWith(MockitoJUnitRunner.class)
public class DoorServiceTest {
	@InjectMocks
	DoorService doorService;

	@Mock
	DoorRepo doorRepo;

	@Test
	public void createDoorTest()
	{
		Door door = new Door();
		door.setId(1);
		door.setFloorId(1);
		door.setDoorName("Door1");

		Mockito.when(doorRepo.save(door)).thenReturn(Mockito.any());
		String result = doorService.createDoor(door);
		Assert.assertEquals("success", result);


	}
	@Test
	public void createDoorFailureTest()
	{
		Door door = new Door();
		door.setId(1);
		door.setFloorId(1);
		door.setDoorName("");
		String result = doorService.createDoor(door);
		Assert.assertEquals("failure", result);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getDoorTest()
	{
		Door door = new Door();
		door.setId(1);
		door.setFloorId(1);
		door.setDoorName("Door1");

		Mockito.when(doorRepo.findById(1)).thenReturn(door);
		Door door1 = doorService.getDoor("1");
		Assert.assertEquals(door, door1);


	}
}
