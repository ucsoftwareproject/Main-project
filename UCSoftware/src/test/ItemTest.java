package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Main.item;

class ItemTest {


	@Test
	void testGetCost() {
		item Item = new item("TestName", 0, 10f, 0, 10f);
		assertEquals(10f, Item.getCost());
	}

	@Test
	void testGetType() {
		item Item = new item("TestName", 0, 10f, 0, 10f);
		assertEquals(0, Item.getType());
	}

	@Test
	void testGetName() {
		item Item = new item("TestName", 0, 10f, 0, 10f);
		assertEquals("TestName", Item.getName());
		
	}

	@Test
	void testGetImprovement() {
		item Item = new item("TestName", 0, 10f, 0, 12f);
		assertEquals(12f, Item.getImprovement());
	}

}
