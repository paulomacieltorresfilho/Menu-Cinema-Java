package components;

import components.Sessao;
import components.Filme;

import java.util.ArrayList;

public class Calendario {
	private ArrayList< Object >films = new ArrayList< Object >();
	private ArrayList< Object >sessions = new ArrayList< Object >();
	
	public Calendario() {
		
	}
	
	public ArrayList< Object > getfilms() {
		return films;
	}
	public void setFilms(ArrayList< Object > films) {
		this.films = films;
	}
	
	public ArrayList< Object > getSessions() {
		return sessions;
	}
	public void setSessions(ArrayList< Object > sessions) {
		this.sessions = sessions;
	}
	
	
}