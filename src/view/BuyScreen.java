package view;

import javax.swing.*;

public class BuyScreen {
	
	private static int screenSize[] = {800, 400};
	
	private JFrame screen;
	private JLabel title;

	 public BuyScreen() {
		 screen = new JFrame("Comprar ingresso");
		 
		 
		 
		 screen.add(title);
		 screen.setLayout(null);
		 screen.setSize(screenSize[0], screenSize[1]);
		 screen.setLocationRelativeTo(null);
		 screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 screen.setVisible(true);
	 }
}
