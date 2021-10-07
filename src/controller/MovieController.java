package controller;

import java.util.ArrayList;

import model.Movie;

public class MovieController{
	
	public static ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	public static void addRandomData() {
		for (int i = 10; i > 0; i--) {
			movieList.add(new Movie(
					String.format("filme-%d", i),
					"pouco importa irmão",
					String.format("comédia?%d", 10 - i),
					(i * i * 100)
					));
		}
	}
	
	public static Movie createMovie(String name, String synopsis, String genre, int duration) {
		return new Movie (name, synopsis, genre, duration);
	}

	public static String[] getMovieInfo(int id) {
		Movie m = MovieController.getMovie(id);
		String[] mInfo = {
			m.getName(),
			m.getSynopsis(),
			m.getGenre(),
			Integer.toString(m.getDuration())
		};
		return mInfo;
	}
	
	public static void register(Movie m) {
		if (!movieList.contains(m)) {
			movieList.add(m);
		}
	}

	public static void update(int id, Movie m) {
		movieList.remove(id);
		movieList.add(id, m);
	}
	
	public static void remove(Movie m) {
		SessionController.removeAll(m);
		movieList.remove(m);
	}
	
	public static void remove(int id) {
		Movie m = MovieController.getMovie(id);
		SessionController.removeAll(m);
		movieList.remove(m);
	}
	
	public static ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
	public static Movie getMovie(int index) {
		return movieList.get(index);
	}
	
	public static int getListSize() {
		return movieList.size();
	}
}
