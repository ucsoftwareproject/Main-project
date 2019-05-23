package test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import Main.*;
import org.junit.jupiter.api.Test;

class Type2Test {
	private member testMember; 
	private Type2 type;
	List<Type2> masterTypes = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		masterTypes.add(new Type2("ENGINEER"));
		testMember = new member ("Test", masterTypes.get(0));
		type = masterTypes.get(0);
	}
	
	@Test
	void testGetBaseTiredness() {
		float testFloat = type.getBaseTiredness();
		assertTrue(testFloat == 5);
	}
	
	@Test
	void testGetBaseHealth() {
		float testFloat = type.getBaseHealth();
		assertTrue(testFloat == 5);
	}
	
	@Test
	void testGetBaseRepair() {
		float testFloat = type.getBaseRepair();
		assertTrue(testFloat == 8);
	}
	
	@Test
	void testGetTypeName() {
		String typeName = type.getTypeName();
		assertTrue(typeName.equals("Engineer"));
	}

}
