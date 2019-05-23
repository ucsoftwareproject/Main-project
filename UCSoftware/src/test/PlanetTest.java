package test;

import static org.junit.jupiter.api.Assertions.*;
import Main.*;

import org.junit.jupiter.api.Test;

class PlanetTest {

	@Test
	void testSearched() {
		Planet planet = new Planet();
		planet.searched();
		assertTrue(planet.isSearched());
	}

	@Test
	void testNewPlanet() {
		Planet planet = new Planet();
		planet.searched();
		planet.newPlanet();
		assertFalse(planet.isSearched());
	}

	@Test
	void testIsSearched() {
		Planet planet = new Planet();
		assertFalse(planet.isSearched());
	}

}
