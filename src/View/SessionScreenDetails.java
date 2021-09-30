package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

import Controller.MovieController;
import Controller.SessionController;
import Model.Session;

public class SessionScreenDetails 
extends ScreenDetailsBase
implements ActionListener{
	String[] sessionsIds = new String[1000];	
	private JComboBox<String> films;
	private SessionController sessionData;
	private MovieController filmsData;
	private ArrayList<Session> sessions;
	private int pos;
	
	public SessionScreenDetails(SessionController sessionData, int pos, MovieController filmsData) {
		super();
		this.pos = pos;
		this.sessionData = sessionData;
		this.filmsData = filmsData;
		sessions = sessionData.getSession();
		Session session = sessions.get(pos);
			
		
		sessionsIds = filmsData.view();
		
		films = new JComboBox<String>(sessionsIds);
		films.setBounds(100, 10, 150,30);
		menu.add(films);
		
		l1.setVisible(false);
		l2.setText(Character.toString(session.getRoom()));

		l3.setText(String.valueOf(session.getDate().getTime()));
		session.getDate();
		l4.setText(String.valueOf(GregorianCalendar.MINUTE));
		l5.setVisible(false);
		
		menu.setTitle("Detalhes da sessão");
		lL1.setText("Filme: ");
		lL2.setText("Sala: ");
		lL3.setText("Dia: ");
		lL4.setText("Horário: ");
		
		save.addActionListener(this);
		remove.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == save) {
			try {
				GregorianCalendar d = new GregorianCalendar(2021,1,1,0,0);
				
				Session s = new Session(
						filmsData.getFilms().get(films.getSelectedIndex()),
						d,
						l2.getText().charAt(0));
				this.sessionData.update(pos, s);
				messageSave();	
				
			} catch (Exception e1) {
				massageErroRegister();
			}
		}
		if(src == remove) {
			this.sessionData.delete(pos);
			messageRemove();
		}
	}

}
