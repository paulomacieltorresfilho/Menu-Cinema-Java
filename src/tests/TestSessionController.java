package tests;

import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

import controller.*;

public class TestSessionController extends TestCase {

	@Test
	public void testIsSessionAvailable() throws Exception {
		
	
		MovieController.register(MovieController.createMovie(
				"as aventuras de pi",
				"aaa",
				"aaa",
				100
				));
			
	//	String movieName, String room, String date, String time
		SessionController.register(SessionController.createSession(
					"as aventuras de pi",
					"a",
					"09/10/2000",
					"10:00"
				));
		
		assertTrue(
				SessionController.isSessionAvailable(SessionController.createSession(
					"as aventuras de pi",
					"a",
					"09/10/2000",
					"8:19"
				))
			);
		assertTrue(
				SessionController.isSessionAvailable(SessionController.createSession(
					"as aventuras de pi",
					"a",
					"09/10/2000",
					"11:41"
				))
			);
		assertFalse(
				SessionController.isSessionAvailable(SessionController.createSession(
					"as aventuras de pi",
					"a",
					"09/10/2000",
					"9:30"
				))
			);
		assertFalse(
				SessionController.isSessionAvailable(SessionController.createSession(
					"as aventuras de pi",
					"a",
					"09/10/2000",
					"10:30"
				))
			);
	}
}
