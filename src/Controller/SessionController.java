package Controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import Model.Movie;
import Model.Session;

public class SessionController implements Entity{
	private ArrayList<Session> sessions = new ArrayList<Session>();
	
	public SessionController(ArrayList<Movie> movie) {
		//Dados aleatorios
		for(int i=0; i < 5; i++) {
			Movie m = movie.get(i);
			GregorianCalendar d = new GregorianCalendar(2021,9,21,(i*3), (i*5));
			char c;
			if(i == 0) c = 'a';
			else c='d';
			if(i==2) c ='b';
			if(i==3) c ='c';
			
			Session s = new Session(m, d, c);
			this.sessions.add(s);
		}
		//end
	}
	
	public ArrayList<Session> getSession() {
		return sessions;
	}
	
	@Override
	public void register(Object session) {
		sessions.add((Session) session);
	}

	@Override
	public void update(int pos, Object session) {
		sessions.remove(pos);
		sessions.add(pos, (Session) session);
	}
	
	public void update(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}
	
	@Override
	public String[] view() {
		String[] sessionsIds = new String[1000];	
		for(int i = 0; i < sessions.size(); i++) {
			Session aux;
			
			aux = this.sessions.get(i);
			sessionsIds[i] = aux.getMovie().getName()+"| Sala "+aux.getRoom();
		}
		return sessionsIds;
	}

	@Override
	public void delete(int pos) {
		sessions.remove(pos);
	}

}
