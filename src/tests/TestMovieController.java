package tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.*;


class TestMovieController {

	
	@Test
	void testaddRandomData() {
		MovieController.addRandomData();
		assertNotEquals(MovieController.getMovieList(), null);
	}
	
	@Test
	void testCreateMovie() {
		String name = "Casa";		
		MovieController.register(MovieController.createMovie(name, "sobre a casa", "romace", 120));
		assertEquals(MovieController.getMovie(name).getName(), name);
	}

	@Test
	void testGetMovieList() {
		MovieController.addRandomData();
		assertNotEquals(MovieController.getMovie(0), null);
	}

	@Test
	void testGetGenreList() {
		assertTrue(MovieController.getGenreList().getClass().isArray());
	}

}
