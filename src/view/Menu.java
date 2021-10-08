package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controller.*;


public class Menu implements ActionListener{
	
	private static int menuWidth = 800;
	private static int menuHeight = 285;

	private JFrame menu = new JFrame("Cinema");
	private JLabel title = new JLabel("Cinema");	
	private JButton btMovie = new JButton("FILMES");
	private JButton btSession = new JButton("SESSÕES");
	private JButton btSnack = new JButton("LANCHES");
	private JButton btTicket = new JButton("COMPRAR TICKET");
	
	public Menu() {

		int btXPosition = Menu.getCenteredPosition(menuWidth, 200);
		Font btFont = new Font("Arial", Font.PLAIN, 13);

		MovieController.addRandomData();
		SnackController.addRandomData();
		SessionController.addRandomData();
		
		title.setFont(new Font("Arial", Font.PLAIN , 18));
		title.setBounds(Menu.getCenteredPosition(menuWidth, 62),10,62,30);
		btMovie.setFont(btFont);
		btMovie.setBounds(btXPosition,50,200,35);
		btSession.setFont(btFont);
		btSession.setBounds(btXPosition,100,200,35);
		btSnack.setFont(btFont);
		btSnack.setBounds(btXPosition,150,200,35);
		btTicket.setFont(btFont);
		btTicket.setBounds(btXPosition, 200, 200, 35);
		
		menu.add(title);
		menu.add(btMovie);
		menu.add(btSession);
		menu.add(btSnack);
		menu.add(btTicket);
		
		menu.setLayout(null);
		menu.setSize(menuWidth, menuHeight);
		menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setVisible(true);

		btMovie.addActionListener(this);
		btSession.addActionListener(this);
		btSnack.addActionListener(this);
	}

	public void changeVisibility() {
		menu.setVisible(!menu.isVisible());
	}
	
	public static int getCenteredPosition(int frameSize, int labelSize) {
		return (frameSize - labelSize) / 2;
	}
	
	public static void main(String[] args) {
		new Menu();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btMovie) {
			new MovieScreen();
		}
		if (src == btSession) {
			new SessionScreen();
		}
		if (src == btSnack) {
			new SnackScreen();
		}
		if (src == btTicket) {
			new TicketScreen();
		}
		
	}

}
