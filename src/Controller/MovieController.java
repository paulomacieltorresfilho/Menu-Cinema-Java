package Controller;

import java.util.ArrayList;

import Model.Movie;

public class MovieController implements Entity{
	ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	public MovieController() {		
		// dados aleatorios
		for(int i=0; i < 5; i++) {
			Movie aux = new Movie(i, "nome-"+(i+1), "qualquercoisa", "A��o", (120+i));
			this.movieList.add(aux);
		} 
	}
	
	public ArrayList<Movie> getMovies() {
		return movieList;
	}

	@Override
	public void register(Object e) {
		movieList.add((Movie) e);		
	}

	@Override
	public void update(int pos, Object e) {
		movieList.remove(pos);
		movieList.add(pos, (Movie) e);
	}
	
	public void update(ArrayList<Movie> films) {
		this.movieList = films;
	}

	@Override
	public String[] view() {
		String[] filmsName = new String[1000];	
		for(int i = 0; i < movieList.size(); i++) {
			Movie aux;
			
			aux = movieList.get(i);
			filmsName[i] = aux.getName();
		}
		return filmsName;
		
	}
	
	@Override
	public void delete(int pos) {
		movieList.remove(pos);
	}

	
}
