package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controller.*;


public class Menu implements ActionListener{
	
	private static int menuWidth = 800;
	private static int menuHeight = 600;
	public static String fontFamily = "Arial";
	
	public static int windowWidth = 760;
	public static int windowHeight = 300;

	private static JFrame menu = new JFrame("Cinema");
	private static JLabel title = new JLabel("Cinema");	
	private static JButton btMovie = new JButton("FILMES");
	private static JButton btSession = new JButton("SESSÕES");
	private static JButton btSnack = new JButton("LANCHES");
	
	public Menu() {
		MovieController.addRandomData();
		SnackController.addRandomData();
		SessionController.addRandomData();
		
		title.setFont(new Font(fontFamily, Font.PLAIN , 18));
		title.setBounds(Menu.getCenteredPosition(menuWidth, 62),10,62,30);
		btMovie.setFont(new Font(fontFamily, Font.PLAIN , 13));
		btMovie.setBounds(Menu.getCenteredPosition(menuWidth, 200),50,200,35);
		btSession.setFont(new Font(fontFamily, Font.PLAIN, 13));
		btSession.setBounds(Menu.getCenteredPosition(menuWidth, 200),100,200,35);
		btSnack.setFont(new Font(fontFamily, Font.PLAIN, 13));
		btSnack.setBounds(Menu.getCenteredPosition(menuWidth, 200),150,200,35);
		
		menu.add(title);
		menu.add(btMovie);
		menu.add(btSession);
		menu.add(btSnack);
		
		menu.setLayout(null);
		menu.setSize(menuWidth, menuHeight);
		menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setVisible(true);
	}
	
	public static void changeVisibility() {
		menu.setVisible(!menu.isVisible());
	}
	
	public static int getCenteredPosition(int frameSize, int labelSize) {
		return (frameSize - labelSize) / 2;
	}
	
	public static void main(String[] args) {
		Menu m =  new Menu();
		
		btMovie.addActionListener(m);
		btSession.addActionListener(m);
		btSnack.addActionListener(m);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btMovie){
			new MovieScreen();
		}
		if (src == btSession) {
			new SessionScreen();
		}
		if (src == btSnack) {
			new SnackScreen();
		}
		
	}

}
