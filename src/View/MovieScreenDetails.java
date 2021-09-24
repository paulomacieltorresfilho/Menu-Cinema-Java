package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controller.MovieController;
import Controller.SessionController;
import Model.Movie;
import Model.Session;

public class MovieScreenDetails 
extends ScreenDetailsBase
implements ActionListener{

	private MovieController movieData;
	private SessionController sessionData;
	private ArrayList<Movie> movieList;
	private int pos;
	
	public MovieScreenDetails(MovieController movieData, int pos, SessionController sessionData) {
		super();
		this.pos = pos;
		this.movieData = movieData;
		this.sessionData = sessionData;
		movieList = movieData.getMovies();
		Movie movie = movieList.get(pos);
			
		l1.setText(String.valueOf(movie.getId()));
		l2.setText(movie.getName());
		l3.setText(movie.getSynopsis());
		l4.setText(movie.getGenre());
		l5.setText(String.valueOf(movie.getDuration()));
		
		menu.setTitle("Detalhes do filme");
		lL1.setText("Id: ");
		lL2.setText("Nome: ");
		lL3.setText("Sinopse: ");
		lL4.setText("G�nero: ");
		lL5.setText("Dura��o: ");
		
		save.addActionListener(this);
		remove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == save) {
			try {
				Movie m = new Movie(
						Integer.valueOf(l1.getText()),
						l2.getText(),
						l3.getText(),
						l4.getText(),
						Integer.valueOf(l5.getText())
						);
				this.movieData.update(pos, m);
				
				messageSave();	
				
			} catch (Exception e1) {
				massageErroRegister();
			}
		}
		if(src == remove) {
			this.movieData.delete(pos);
			messageRemove();
		}
		
		int x = 0;
		for(Session session: sessionData.getSession()) {
			int i = 0;
			for(Movie movie: movieData.getMovies()) {
				if(session.getMovie().equals(movie)) {
					i++;
				}
			}
			if(i == 0) {
				sessionData.delete(x);
			}
			x++;
		}

	}

}
