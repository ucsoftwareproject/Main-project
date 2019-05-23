package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import Main.*;
import org.junit.jupiter.api.Test;

class CrewTest {
	public member testMember;
	private Type2 type;
	List<Type2> masterTypes = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		masterTypes.add(new Type2("ENGINEER"));
		testMember = new member ("Test", masterTypes.get(0));

	}
	
	@Test
	void testGetName() {
		crew Crew1 = new crew("Test_", 4);
		Crew1.setName("Test");
		assertTrue(Crew1.getName().equals("Test"));
		//just a small extra test
		assertEquals(Crew1.getMaxSize(), 4);
	}
	
	
	
	@Test
	void testGetCrewSize() {
		crew Crew1 = new crew("Test_", 4);
		Crew1.addMember(testMember);	
		assertEquals(Crew1.getSize(), 2);
	}
	
	@Test
	void testAddMember() {
		crew Crew10 = new crew("Test_", 4);;
		member testMember2;
		testMember2 = new member ("Test", masterTypes.get(0));
		Crew10.addMember(testMember2);
		assertEquals(Crew10.getSize(), 3);
	}
	
	@Test
	void testGetMoney() {
		crew Crew1 = new crew("Test_", 4);
		assertEquals(Crew1.getMoney(), 100);
		Crew1.addMoney(10);
		assertEquals(Crew1.getMoney(), 110);
		Crew1.subMoney(100);
		assertEquals(Crew1.getMoney(), 10);
		Crew1.setMoney(0);
		assertEquals(Crew1.getMoney(), 0);
		
	}
	
	@Test
	void testgetMembers() {
		crew Crew1 = new crew("Test_", 4);
		assertEquals(Crew1.getMembers().size(), Crew1.getSize());
		
	}
	
	@Test
	void testremoveMember() {
		crew Crew4 = new crew("Test_", 4);
		Crew4.addMember(testMember);
		Crew4.removeMember(testMember);;
		assertEquals(Crew4.getMembers().size(), 2);
		
	}
	
	@Test
	void testgetItem() {
		crew Crew2 = new crew("Test_", 4);
		item Item1 = new item("test1", 0, 10f, 0, 10f);
		item Item2 = new item("test2", 0, 10f, 1, 10f);
		item Item3 = new item("test3", 0, 10f, 2, 10f);
		Crew2.addItem(Item1);
		assertEquals(Crew2.getItem(0), Item1);
		Crew2.addItem(Item2);
		Crew2.addItem(Item3);
		Crew2.removeItem(0);
		assertEquals(Crew2.getAllItems().size() , 2);
		
	}
	
	@Test
	void testevents() {
		//just used to test if we get a crash
		crew Crew2 = new crew("Test_", 4);
		Crew2.addMember(testMember);
		item Item1 = new item("test1", 0, 10f, 0, 10f);
		Crew2.addItem(Item1);
		item Item2 = new item("test2", 0, 10f, 0, 10f);
		Crew2.addItem(Item2);
		Crew2.plage();
		Crew2.alien();
		Crew2.debug();
		
	}
		
	
}
