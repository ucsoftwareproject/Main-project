package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import Main.GameEnvironment;
import Main.Type2;
import Main.item;

class GameEnvironmentTest {

	@Test
	void testOutpost() {
		GameEnvironment engine = new GameEnvironment();
		assertEquals(6, engine.shop_items().size());
		assertEquals(engine.getOutpost(), engine.Outpost);
	}
	
	@Test
	void testName() {
		GameEnvironment engine = new GameEnvironment();
		engine.setShipName("bob");
		assertEquals("bob", engine.getShipName());
	}
	
	@Test
	void testDay() {
		GameEnvironment engine = new GameEnvironment();
		engine.setDays(9);
		engine.addDay();
		engine.addDay();
		engine.minusDay();
		engine.minusDay();
		engine.minusDay();
		engine.endDay();
		engine.dayDebug();
		
		assertEquals("6", engine.getDay());
	}
	
	@Test
	void testmember() {
		GameEnvironment engine = new GameEnvironment();
		
		engine.addMember("Test", new Type2("ENGINEER"));
		engine.crewDebug();
		
		assertEquals("Test", engine.Crew.getMembers().get(0).getName());
		
	}
	
	@Test
	void testCrew() {
		GameEnvironment engine = new GameEnvironment();
		
		engine.addMember("name", new Type2("ENGINEER"));
		int temp = engine.Crew.getMoney();
		engine.crewAddMoney(100);
		assertTrue(engine.Crew.getMoney() >= temp & engine.Crew.getMoney() <= temp + 100);
		
	}
	
	@Test
	void testPlanet() {
		GameEnvironment engine2 = new GameEnvironment();
		assertFalse(engine2.searched());
		engine2.planetSearched();
		assertTrue(engine2.searched());
		engine2.newPlanet();
		assertFalse(engine2.searched());
	}
	
	@Test
	void testparts() {
		GameEnvironment engine3 = new GameEnvironment();
		engine3.setPartsNeeded(6);
		assertEquals(4, engine3.partsNeeded);
		assertEquals(4, engine3.partsTotal());
		assertEquals(0, engine3.partsCurrent());
		engine3.addPart();
		assertEquals(1, engine3.partsCurrent());
		assertEquals(4, engine3.getPartsNeeded());
	}
	
	@Test
	void testSheild() {
		GameEnvironment engine4 = new GameEnvironment();
		assertEquals(10, engine4.getShieldHP());
		engine4.addShieldHP(100);
		assertEquals(110, engine4.getShieldHP());
		engine4.damageShield(110);
		assertEquals(0, engine4.getShieldHP());

	}
	@Test
	void testscore() {
		GameEnvironment engine5 = new GameEnvironment();
		engine5.crewAddItem(new item("test10", 0, 10f, 0, 10f));
		engine5.addMember("Test234", new Type2("ENGINEER"));
		engine5.addMember("Test123", new Type2("PUSHOVER"));
		System.out.println("Check by hand: " + engine5.getScore());

	}

}
