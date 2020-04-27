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
import com.apartment.keerthi.persistence.ApartmentRepo;
import com.apartment.keerthi.serviceImpl.ApartmentService;


@RunWith(MockitoJUnitRunner.class)
public class ApartmentServiceTest {
	
	@InjectMocks
	ApartmentService apartmentService;
	
	@Mock
	ApartmentRepo apartmentRepo;
	
	@Test
	public void createApartment()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentRepo.save(apartment)).thenReturn(Mockito.any());
		String result = apartmentService.createApartment(apartment);
		Assert.assertEquals("success", result);

		
	}
	@Test
	public void createApartmentFailure()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("");
		apartment.setBlock(getBlock());
		
		String result = apartmentService.createApartment(apartment);
		Assert.assertEquals("failure", result);

		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getApartment()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentRepo.findById(1)).thenReturn(apartment);
		Apartment apartment1 = apartmentService.getApartment("1");
		Assert.assertEquals(apartment, apartment1);

		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getApartmentFailure()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Apartment apartment1 = apartmentService.getApartment("O");
		Assert.assertEquals(null, apartment1);

		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void deleteApartmentTest()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		Mockito.when(apartmentRepo.findById(1)).thenReturn(apartment);
		Mockito.doNothing().when(apartmentRepo).deleteById(1);
		 String status = apartmentService.deleteApartment("1");
		Assert.assertEquals("success", status);

		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void deleteApartmentFailureTest()
	{
		Apartment apartment = new Apartment();
		apartment.setId(1);
		apartment.setName("Apartment1");
		apartment.setBlock(getBlock());
		
		 String status = apartmentService.deleteApartment("O");
		Assert.assertEquals("failure", status);

		
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
