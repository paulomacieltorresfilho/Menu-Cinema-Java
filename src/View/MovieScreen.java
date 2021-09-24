package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.MovieController;
import Controller.SessionController;
import Model.Movie;

public class MovieScreen 
extends ScreenBase
implements ActionListener, ListSelectionListener{
	
	String[] filmsName = new String[1000];	
	private static MovieController filmsData;
	ArrayList<Movie> films;
	SessionController sessionData;
	
	public MovieScreen(MovieController filmsData, SessionController sessionData) {
		super();
		this.sessionData = sessionData;
		MovieScreen.filmsData = filmsData;
		films = filmsData.getFilms();
		filmsName = filmsData.view();
		
		menu.setTitle("Filmes");
		title.setText("Lista de filmes");
		
		list.setListData(filmsName);
		
		btAdd.addActionListener(this);
		btAtt.addActionListener(this);
		list.addListSelectionListener(this);
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting()&& src == list) {
			new MovieScreenDetails(filmsData, list.getSelectedIndex(), sessionData);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == btAdd) {
			Movie m = new Movie(-1, null, null, null, 0);
			int pos = films.size();
			films.add(pos, m);
			filmsData.update(films);
			
			new MovieScreenDetails(filmsData, pos, sessionData);
		}
		if(src == btAtt) {
			filmsName = new String[1000];
			filmsName = filmsData.view();
			list.setListData(filmsName);

		}
	}
	
}
