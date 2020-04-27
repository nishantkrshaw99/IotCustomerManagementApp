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

import com.apartment.keerthi.controller.ApartmentController;
import com.apartment.keerthi.entity.Apartment;
import com.apartment.keerthi.entity.Block;
import com.apartment.keerthi.entity.Door;
import com.apartment.keerthi.entity.Floor;
import com.apartment.keerthi.serviceImpl.ApartmentService;

@RunWith(MockitoJUnitRunner.class)
public class ApartmentControllerTest {
	@InjectMocks
	ApartmentController apartmentController;
	
	@Mock
	ApartmentService apartmentService;
	
	@SuppressWarnings("deprecation")
	@Test
	public void createApartment()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentService.createApartment(Mockito.any())).thenReturn("success");
		ResponseEntity<Object> result = apartmentController.createApartment(apartment);
		Assert.assertEquals("Apartment is created successfully", result.getBody());

		
	}
	@Test
	public void createApartmentfailure()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentService.createApartment(Mockito.any())).thenReturn("failure");
		ResponseEntity<Object> result = apartmentController.createApartment(apartment);
		Assert.assertEquals(500, result.getStatusCodeValue());

		
	}
	@Test
	public void getApartment()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentService.getApartment(Mockito.anyString())).thenReturn(apartment);
		ResponseEntity<Object> result = apartmentController.getApartment("1");
		Assert.assertEquals(apartment, result.getBody());
	}
	@Test
	public void getApartmentFailureTest()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentService.getApartment(Mockito.anyString())).thenReturn(null);
		ResponseEntity<Object> result = apartmentController.getApartment("O");
		Assert.assertEquals(500, result.getStatusCodeValue());
	}
	@Test
	public void deleteApartmentTest()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentService.deleteApartment(Mockito.anyString())).thenReturn("success");
		ResponseEntity<Object> result = apartmentController.deleteApartment("1");
		Assert.assertEquals(201, result.getStatusCodeValue());
	}
	@Test
	public void deleteApartmentFailureTest1()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentService.deleteApartment(Mockito.anyString())).thenReturn("missing");
		ResponseEntity<Object> result = apartmentController.deleteApartment("O");
		Assert.assertEquals(500, result.getStatusCodeValue());
	}
	@Test
	public void deleteApartmentFailureTest2()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentService.deleteApartment(Mockito.anyString())).thenReturn("failure");
		ResponseEntity<Object> result = apartmentController.deleteApartment("1");
		Assert.assertEquals(500, result.getStatusCodeValue());
	}
private List<Block> getBlock() {
	// TODO Auto-generated method stub
	List<Block> block = new ArrayList();
	Block block1 = new Block();
	block1.setId(1);
	block1.setBlockName("Block1");
	block1.setApartmentId(1);
	block1.setFloor(getfloor());
	block.add(block1);
	
	return block;
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
