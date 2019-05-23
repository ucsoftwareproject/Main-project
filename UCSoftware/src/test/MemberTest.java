package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import Main.*;
import org.junit.jupiter.api.Test;



public class MemberTest{
	private member testMember; 
	private Type2 type;
	List<Type2> masterTypes = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		masterTypes.add(new Type2("ENGINEER"));
		testMember = new member ("Test", masterTypes.get(0));
	}
	
	@Test
	void testPlage() {
		testMember.plague();
		assertTrue(testMember.getStatus());
	}
	
	@Test
	void testGetName() {
		String testName = testMember.getName();
		assertTrue(testName.equals("Test"));
	}
	
	@Test
	void testGetStatus(){
		Boolean status = testMember.getStatus();
		assertFalse(status);
	}
	
	@Test
	void testGetHealth() {
		float health = testMember.getHealth();
		assertTrue(health == 50);
	}
	
	@Test
	void testGetTiredness() {
		float tiredness = testMember.getTiredness();
		assertTrue(tiredness == 50);
	}
	
	@Test
	void testGetHunger() {
		float hunger = testMember.getHunger();
		assertTrue(hunger == 50);
	}
	
	@Test
	void testGetTypeName() {
		String name = testMember.getTypeName();
		assertTrue(name == "Engineer");
	}
	
	@Test
	void testgetBaseRepair() {
		float repair = testMember.getBaseRepair();
		assertTrue(repair == 8);
	}
	
	@Test
	void testSetActions() {
		testMember.setActions(5);
		float actions = testMember.getActions();
		assertTrue(actions == 5);
	}
	
	@Test
	void testSleep() {
		testMember.sleep();
		float tiredness = testMember.getTiredness();
		assertTrue(tiredness == 80);
	}
	
	@Test
	void testWork() {
		testMember.work();
		float tiredness = testMember.getTiredness();
		assertTrue(tiredness == 40);
	}
	
	@Test
	void testConsumeAction() {
		testMember.setActions(5);
		testMember.consumeAction();
		assertTrue(testMember.getActions() == 4);
	}

	@Test
	void testEat() {
		testMember.eat(20);
		assertTrue(testMember.getHunger() == 70);
	}	
	
	@Test
	void testLoseHunger() {
		testMember.loseHunger();
		assertTrue(testMember.getHunger() == 40);
	}
	
	@Test
	void testuseItem() {
		item Item1 = new item("test1", 0, 10f, 0, 10f);
		item Item2 = new item("test2", 0, 10f, 1, 10f);
		item Item3 = new item("test3", 0, 10f, 2, 10f);
		testMember.useItem(Item1);
		assertTrue(testMember.getHunger() == 60f);
		testMember.useItem(Item2);
		assertTrue(testMember.getHealth() == 60f);
		testMember.useItem(Item3);
		assertTrue(testMember.getHealth() == 70f);
		assertTrue(testMember.getHunger() == 70f);
		
		
	}
	
	@Test
	void testLoseHealth() {
		testMember.loseHealth(20);
		assertTrue(testMember.getHealth() == 30);
	}
	
	@Test
	void testMeds() {
		testMember.plague();
		
		testMember.meds(30);
		assertTrue(testMember.getHealth() == 80);
		assertFalse(testMember.getStatus());

	}
}