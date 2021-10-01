package view;

import javax.swing.*;

import controller.MovieController;
import controller.SessionController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import model.Session;

public class SessionDetails implements ActionListener{
	
	private static int inputSize[] = {250, 25};
	private static int labelSize[] = {150, 25};
	private static int buttonsSize[] = {250, 65};
	private static int labelInputXDis = 30 + labelSize[0];
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);

	private JFrame screen = new JFrame("");
	private JLabel roomLabel = new JLabel("Sala:");
	private JTextField roomInput = new JTextField("");
	private JLabel dateLabel = new JLabel("Data:");
	private JTextField dateInput = new JTextField("");
	private JLabel genreLabel = new JLabel("Filme:");
	private JTextField genreInput = new JTextField("");

	
	private static JButton btSave = new JButton("Salvar");
	private static JButton btCancel = new JButton("Cancelar");
	
	private Session session;
	private boolean updating;
	
	public void displayScreen() {
		
		roomLabel.setBounds(30, 40,labelSize[0], labelSize[1]);
		roomInput.setBounds(labelInputXDis, 40, inputSize[0], inputSize[1]);
		roomLabel.setFont(f);
		roomInput.setFont(f);
		
		dateLabel.setBounds(30, 80,labelSize[0], labelSize[1]);
		dateInput.setBounds(labelInputXDis, 80, inputSize[0], inputSize[1]);
		dateLabel.setFont(f);
		dateInput.setFont(f);
		
		genreLabel.setBounds(30, 120,labelSize[0], labelSize[1]);
		genreInput.setBounds(labelInputXDis, 120, inputSize[0], inputSize[1]);
		genreLabel.setFont(f);
		genreInput.setFont(f);
		
		btSave.setBounds(
				labelInputXDis + inputSize[0] + 50,
				40,
				buttonsSize[0],
				buttonsSize[1]);
		btCancel.setBounds(
				labelInputXDis + inputSize[0] + 50,
				120,
				buttonsSize[0],
				buttonsSize[1]);
		btSave.setFont(f);
		btCancel.setFont(f);
		
		screen.add(btSave);
		screen.add(btCancel);
		screen.add(roomLabel);
		screen.add(roomInput);
		screen.add(dateLabel);
		screen.add(dateInput);
		screen.add(genreLabel);
		screen.add(genreInput);

		screen.setLayout(null);
		screen.setSize(800, 265);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
		
		btSave.addActionListener(this);
		btCancel.addActionListener(this);
	}
	
	public SessionDetails() {
		updating = false;
		displayScreen();
	}
	public SessionDetails(int id) {
		updating = true;
		session = SessionController.getSession(id);
		// roomInput.setText(session.getRoom());
		dateInput.setText(session.getDate().toString());
		genreInput.setText(session.getMovie().getName());
		displayScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btSave) {
			try {	

				session = new Session(
                            MovieController.getMovie(2),
                            new GregorianCalendar(2021, 10, 10 + 2, 10 + 10, 0),
                            'a',
                            false,
                            5
                            );
				
				if (!updating) {
					SessionController.register(session);
				}
				
//				registerSuccessMessage();
				screen.dispose();
				new SessionScreen();	
			} catch (Exception ex){
//				registerErrorMessage();
			}
		}
		if (src == btCancel) {
//			operationCanceledMessage();
			screen.dispose();
			new SessionScreen();	
		}
		
	}
	
}
