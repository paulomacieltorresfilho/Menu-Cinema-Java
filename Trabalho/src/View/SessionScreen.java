package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.MovieController;
import Controller.SessionController;
import Model.Movie;
import Model.Session;

public class SessionScreen 
extends ScreenBase
implements ActionListener, ListSelectionListener{

	String[] sessionsIds = new String[1000];	
	private SessionController sessionData;
	private MovieController filmsData;
	ArrayList<Session> sessions;
	
	public SessionScreen(SessionController sessionData, MovieController filmsData) {
		super();
		this.sessionData = sessionData;
		this.filmsData = filmsData;
		sessions = sessionData.getSession();
		sessionsIds = sessionData.view();
		
		menu.setTitle("Sessões");
		title.setText("Lista de sessões");
		
		list.setListData(sessionsIds);
		
		btAdd.addActionListener(this);
		btAtt.addActionListener(this);
		list.addListSelectionListener(this);
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting()&& src == list) {
			new SessionScreenDetails(sessionData, list.getSelectedIndex(),filmsData);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == btAdd) {
			Movie m = new Movie(0, "nome", "sinopse", "genero", 0);
			GregorianCalendar d = new GregorianCalendar(2021,1,1,0,0);
			Session s = new Session(m, d, 'a');
			int pos = sessions.size();
			sessions.add(pos, s);
			sessionData.update(sessions);
			
			new SessionScreenDetails(sessionData, pos, filmsData);
		}
		if(src == btAtt) {
			sessionsIds = new String[1000];
			sessionsIds = sessionData.view();
			list.setListData(sessionsIds);
		}
	}

}
