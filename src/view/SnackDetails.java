package view;

import javax.swing.*;

import controller.SnackController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnackDetails implements ActionListener{
	
	private static int inputSize[] = {250, 25};
	private static int labelSize[] = {150, 25};
	private static int buttonsSize[] = {250, 65};
	private static int labelInputXDis = 30 + labelSize[0];
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);

	private JFrame screen;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JLabel priceLabel;
	private JTextField priceInput;
	private JLabel stockLabel;
	private JTextField stockInput;
	
	private JButton btSave;
	private JButton btCancel;
	
	private String[] snackInfo;
	private int snackId;
	private boolean updating;

	public void initFrame() {
		this.screen = new JFrame("");
		this.nameLabel = new JLabel("Nome:");
		this.nameInput = new JTextField("");
		this.priceLabel = new JLabel("Preço:");
		this.priceInput = new JTextField("");
		this.stockLabel = new JLabel("Qtd Estoque:");
		this.stockInput = new JTextField("");
		
		this.btSave = new JButton("Salvar");
		this.btCancel = new JButton("Cancelar");
		this.btSave.addActionListener(this);
		this.btCancel.addActionListener(this);
	}
	
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
	}
	
	public SnackDetails() {
		initFrame();
		updating = false;
		displayScreen();
	}
	public SnackDetails(int id) {
		initFrame();
		updating = true;
		this.snackInfo = SnackController.getSnackInfo(id);
		this.snackId = id;

		nameInput.setText(snackInfo[0]);
		priceInput.setText(snackInfo[1]);
		stockInput.setText(snackInfo[2]);
		displayScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btSave) {
			try {	
				btSave.removeActionListener(this);
				if (!updating) {
					SnackController.register(
						SnackController.createSnack(
							nameInput.getText(), 
							Double.parseDouble(priceInput.getText()), 
							Integer.parseInt(stockInput.getText()))
					);
				} else {
					SnackController.update(
						this.snackId,
						SnackController.createSnack(
							nameInput.getText(), 
							Double.parseDouble(priceInput.getText()), 
							Integer.parseInt(stockInput.getText()))
					);
				}
//				registerSuccessMessage();
			} catch (Exception ex){
//				registerErrorMessage();
			} finally {
				screen.dispose();
				new SnackScreen();
			}
		}
		if (src == btCancel) {
			btCancel.removeActionListener(this);
//			operationCanceledMessage();
			new SnackScreen();	
			screen.dispose();
		}
		
	}
	
}