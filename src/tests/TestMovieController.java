package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.*;


class TestMovieController {

	
	@Test
	void testaddRandomData() {
		MovieController.addRandomData();
		assertTrue(MovieController.getMovieList() != null);
	}
	
	@Test
	void testCreateMovie() {
		String name = "Casa";		
		MovieController.register(MovieController.createMovie(name, "sobre a casa", "romace", 120));
		assertTrue(MovieController.getMovie(name).getName().equals(name));
	}

	@Test
	void testGetMovieList() {
		MovieController.addRandomData();
		assertTrue(MovieController.getMovie(0) != null);
	}

	@Test
	void testGetGenreList() {
		assertTrue(MovieController.getGenreList().getClass().isArray());
	}

}
