package controller;

import java.util.ArrayList;
import model.*;

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
	
	public static void register(Movie m) {
		if (!movieList.contains(m)) {
			movieList.add(m);
		}
	}
	
	public static void remove(Movie m) {
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
