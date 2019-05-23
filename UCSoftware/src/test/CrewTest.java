package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import Main.*;
import org.junit.jupiter.api.Test;

class CrewTest {
	public crew Crew1;
	public member testMember; 
	private Type2 type;
	List<Type2> masterTypes = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		masterTypes.add(new Type2("ENGINEER"));
		testMember = new member ("Test", masterTypes.get(0));
		Crew1.addMember(testMember);
	}
	
	@Test
	void testGetName() {
		Crew1.setName("Test");
		assertTrue(Crew1.getName().equals("Test"));
	}
	
	
	
	@Test
	void testGetCrewSize() {
		assertTrue(Crew1.getSize() == 1);
	}
	
	@Test
	void testAddMember() {
		member testMember2;
		testMember2 = new member ("Test", masterTypes.get(0));
		Crew1.addMember(testMember2);
		assertTrue(Crew1.getSize() == 2);
	}
	
	@Test
	void testGetMoney() {
		assertTrue(Crew1.getMoney() == 100);
	}
		
	
}
