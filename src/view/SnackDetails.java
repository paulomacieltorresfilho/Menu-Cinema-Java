package view;

import javax.swing.*;

import controller.SnackController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Snack;

public class SnackDetails implements ActionListener{
	
	private static int inputSize[] = {250, 25};
	private static int labelSize[] = {150, 25};
	private static int buttonsSize[] = {250, 65};
	private static int labelInputXDis = 30 + labelSize[0];
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);

	private static JFrame screen = new JFrame("");
	private static JLabel nameLabel = new JLabel("Nome:");
	private static JTextField nameInput = new JTextField("");
	private static JLabel priceLabel = new JLabel("Preço:");
	private static JTextField priceInput = new JTextField("");
	private static JLabel stockLabel = new JLabel("Qtd Estoque:");
	private static JTextField stockInput = new JTextField("");
	
	private JButton btSave = new JButton("Salvar");
	private JButton btCancel = new JButton("Cancelar");
	
	private Snack snack;
	private boolean updating;
	
	public void displayScreen() {
		
		nameLabel.setBounds(30, 40,labelSize[0], labelSize[1]);
		nameInput.setBounds(labelInputXDis, 40, inputSize[0], inputSize[1]);
		nameLabel.setFont(f);
		nameInput.setFont(f);
		
		priceLabel.setBounds(30, 80,labelSize[0], labelSize[1]);
		priceInput.setBounds(labelInputXDis, 80, inputSize[0], inputSize[1]);
		priceLabel.setFont(f);
		priceInput.setFont(f);
		
		stockLabel.setBounds(30, 120,labelSize[0], labelSize[1]);
		stockInput.setBounds(labelInputXDis, 120, inputSize[0], inputSize[1]);
		stockLabel.setFont(f);
		stockInput.setFont(f);
		
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
		screen.add(nameLabel);
		screen.add(nameInput);
		screen.add(priceLabel);
		screen.add(priceInput);
		screen.add(stockLabel);
		screen.add(stockInput);

		screen.setLayout(null);
		screen.setSize(800, 265);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
		
		btSave.addActionListener(this);
		btCancel.addActionListener(this);
	}
	
	public SnackDetails() {
		updating = false;
		displayScreen();
	}
	public SnackDetails(int id) {
		updating = true;
		snack = SnackController.getSnack(id);
		nameInput.setText(snack.getName());
		priceInput.setText(Double.toString(snack.getPrice()));
		stockInput.setText(Integer.toString(snack.getStockQuantity()));
		displayScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btSave) {
			try {	

				snack = new Snack(
						nameInput.getText(),
						Double.parseDouble(priceInput.getText()),
						Integer.parseInt(stockInput.getText())
						);
				
				if (!updating) {
					SnackController.register(snack);
				}
				
//				registerSuccessMessage();
				btSave.removeActionListener(this);
				new SnackScreen();
				screen.dispose();
			} catch (Exception ex){
//				registerErrorMessage();
				System.out.println("erro irmao");
			}
		}
		if (src == btCancel) {
//			operationCanceledMessage();
			btCancel.removeActionListener(this);
			new SnackScreen();	
			screen.dispose();
		}
		
	}
	
}