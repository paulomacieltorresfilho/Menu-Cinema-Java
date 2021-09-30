package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.SnackController;
import Model.Snack;

public class sellSnackScreen implements ActionListener {
	private JFrame menu = new JFrame("Comprar lanche");
	private JLabel stockQuantity;
	private JTextField quantitySell;
	private JLabel price;
	private JButton sell  = new JButton("Comprar");
	private JLabel snackName;
	
	private SnackController snackData;
	private Snack snack;
	private int pos;
	
	
	public sellSnackScreen(SnackController snackData, int pos) {
		this.snackData = snackData;
		this.snack = snackData.getSnacks().get(pos);
		this.pos = pos;
		
		//label
		stockQuantity = new JLabel("Em estoque: " + String.valueOf(snack.getStockQuantity()));
		price = new JLabel("Preço: " + String.valueOf(snack.getPrice()));
		snackName = new JLabel("Lanche: " + snack.getName()); 
		
		stockQuantity.setBounds(100,40,90,30);
		price.setBounds(100,70,150,30);
		snackName.setBounds(100, 10, 150,30);
		
		menu.add(stockQuantity);
		menu.add(price);
		menu.add(snackName);
		
		//textField
		quantitySell = new JTextField("0");
		quantitySell.setBounds(190,40,50,30);
		menu.add(quantitySell);
		
		//button
		sell.setBounds(100,177,100,30);
		
		menu.add(sell);
		
		//frame
		menu.setLayout(null);
		menu.setSize(400,250);
		menu.setLocation(0, 550);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setVisible(true);
	
		sell.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == sell) {
			if(snack.getStockQuantity() >= Integer.parseInt(quantitySell.getText())) {
				snackData.sellSnack(
						pos,
						Integer.parseInt(quantitySell.getText()));
				menu.dispose();				
			} else {
				JOptionPane.showMessageDialog(null,"Quantidade inválida", "Menssagem de ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
