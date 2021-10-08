package controller;

import java.util.ArrayList;

import model.Movie;

public class MovieController{
	
	private static ArrayList<Movie> movieList = new ArrayList<Movie>();
	private static String[] genres = {
			"Ação",
			"Aventura",
			"Comédia",
			"Corrida",
			"Documentário",
			"Drama",
			"Faroeste",
			"Fantasia",
			"Ficção Científica",
			"Mistério",
			"Musical",
			"Romance",
			"Terror"
	};
	
	
	public static void addRandomData() {
		for (int i = 30; i > 0; i--) {
			movieList.add(new Movie(
					String.format("filme-%d", i),
					"pouco importa irmão",
					genres[0],
					(i * i * 100)
					));
		}
	}
	
	public static Movie createMovie(String name, String synopsis, String genre, int duration) {
		return new Movie (name, synopsis, genre, duration);
	}
	
	public static void register(Movie m) {
		movieList.add(m);
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
	
	public static Object[][] getMovieObjList() {
		Object[][] movieObjList = new Object[MovieController.getListSize()][];
		String[] movieInfo;
		
		for (int i = 0; i < MovieController.getListSize(); i++) {
			movieInfo = MovieController.getMovieInfo(i);
			Object[] aux = {
				i, 
				movieInfo[0],
				movieInfo[2],
				movieInfo[3]	
			};
			movieObjList[i] = aux;
		}
		return movieObjList;
	}
	
	public static Object[][] getMovieObjList(String genre) {
		Object[][] movieObjList = new Object[MovieController.getListSize()][];
		String[] movieInfo;
		
		for (int i = 0; i < MovieController.getListSize(); i++) {
			movieInfo = MovieController.getMovieInfo(i);
			if (movieInfo[2].equals(genre)) {
				Object[] aux = {
					i, 
					movieInfo[0],
					movieInfo[2],
					movieInfo[3]	
				};
				movieObjList[i] = aux;
			}
		}
		
		return movieObjList;
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
	
	public static String[] getMovieNameList() {
		String[] movieNames = new String[MovieController.getListSize()];
		for (int i = 0; i < MovieController.getListSize(); i++) {
			movieNames[i] = movieList.get(i).getName();
		}
		return movieNames;
	}
	
	public static String[] getGenreList() {
		return genres;
	}
	
	public static Movie getMovie(int index) {
		return movieList.get(index);
	}
	
	public static Movie getMovie(String name) {
		for (Movie m : movieList) {
			if (m.getName().equals(name)) return m;
		}
		return null;
	}
	
	public static int getListSize() {
		return movieList.size();
	}
}
