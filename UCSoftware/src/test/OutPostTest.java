package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import Main.*;

import org.junit.jupiter.api.Test;

class OutPostTest {

	@Test
	void testAddItems() {
		outpost Outpost = new outpost();
		Outpost.addItems(new item("test", 0, 10f, 0, 100f));
		Outpost.addItems(new item("test2", 1, 20f, 1, 200f));
		List<item> items = Outpost.getItems();
		assertEquals("test2", items.get(1).getName());
	}

	@Test
	void testClearItems() {
		outpost Outpost = new outpost();
		Outpost.addItems(new item("test", 0, 10f, 0, 100f));
		Outpost.addItems(new item("test2", 1, 20f, 1, 200f));
		Outpost.clearItems();
		List<item> items = Outpost.getItems();
		
		assertEquals(0, items.size());
	}

}
