package view;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.SessionController;
import model.Session;

public class TicketSessionScreen implements ActionListener{
	
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);

	private JFrame screen;
	
	private JPanel sessionPanel;
	private JLabel sessionText;
	private JComboBox<Integer> sessionBox;
	private JButton btSession;
	private int sessionBoxOptionId;
	
	private JPanel seatPanel;
	private JLabel seatText;
	private JComboBox<String> availableSeats;
	
	private JButton btBuy;
	
	private Session s;
	
	public TicketSessionScreen() {
		screen = new JFrame("Comprar Ingresso");
		
		sessionPanel = new JPanel();
		sessionText = new JLabel("Selecione o id da sessão desejada: ");
		sessionBox = new JComboBox<Integer>();
		for (int i = 0; i < SessionController.getListSize(); i++) {
			sessionBox.addItem(i);
		}
		btSession = new JButton("OK");
		
		sessionBox.setBounds(50, 70, 300, 35);
		sessionBox.setFont(f);
		sessionText.setBounds(50, 30, 300, 40);
		sessionText.setFont(f);
		btSession.setBounds(100, 110, 200, 30);
		btSession.setFont(f);
		
		seatPanel = new JPanel();
		seatText = new JLabel("Selecione o assento desejado: ");
		btBuy = new JButton("Comprar Ingresso");
		
		seatText.setBounds(50, 30, 300, 40);
		seatText.setFont(f);
		btBuy.setBounds(100, 110, 200, 30);
		btBuy.setFont(f);
		
		sessionPanel.setLayout(null);
		sessionPanel.setBounds(0, 0, 400, 200);
		sessionPanel.add(sessionText);
		sessionPanel.add(sessionBox);
		sessionPanel.add(btSession);
		
		seatPanel.setVisible(false);
		seatPanel.setLayout(null);
		seatPanel.setBounds(400, 0, 400, 200);
		seatPanel.add(seatText);
		seatPanel.add(btBuy);
		
		screen.add(sessionPanel);
		screen.add(seatPanel);
		
		screen.setSize(800, 230);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setLayout(null);
		screen.setVisible(true);
		
		btSession.addActionListener(this);
		btBuy.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btSession) {
			this.sessionBoxOptionId = (int)sessionBox.getSelectedItem();
			this.s = SessionController.getSession(sessionBoxOptionId);
			availableSeats = new JComboBox<String>(s.getSeatIdList(true));
			availableSeats.setBounds(50, 70, 300, 35);
			availableSeats.setFont(f);
			seatPanel.add(availableSeats);
			seatPanel.setVisible(true);
		}
		if (src == btBuy) {
			
			s.changeSeatAvailability( (String) availableSeats.getSelectedItem());
			
			screen.dispose();
			btSession.removeActionListener(this);
			btBuy.removeActionListener(this);
			new SessionScreen();
		}
	}

}
