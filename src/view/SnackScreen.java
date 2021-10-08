package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.SnackController;

public class SnackScreen implements ActionListener {

	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);
	
	private JFrame tableScreen = new JFrame("Lista de lanches");
	private JFrame controlScreen = new JFrame("Controlador");
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton btAdd;
	private JButton btRemove;
	private JButton btUpdate;
	
	public void initFrame() {
		btAdd.setBounds(50, 30, 200, 40);
		btAdd.setFont(f);
		
		btUpdate.setBounds(300, 30, 200, 40);
		btUpdate.setFont(f);
		btRemove.setBounds(550, 30, 200, 40);
		btRemove.setFont(f);

		
		controlScreen.add(btAdd);
		controlScreen.add(btRemove);
		controlScreen.add(btUpdate);
		
		controlScreen.setLayout(null);
		controlScreen.setSize(800, 150);
		controlScreen.setVisible(true);
		controlScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		table.setEnabled(false);
		table.setFont(f);
		table.getTableHeader().setFont(f);
		
		tableScreen.add(scrollPane); 
		tableScreen.setSize(800, 300);
		tableScreen.setLocationRelativeTo(null);
		tableScreen.setVisible(true);
		tableScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tableScreen.getLocation();
		controlScreen.setLocation((int)tableScreen.getLocation().getX(), (int)tableScreen.getLocation().getY() - 150);
		
		btAdd.addActionListener(this);
		btUpdate.addActionListener(this);
		btRemove.addActionListener(this);
		
	}
	
	public SnackScreen() {
		
		String columns [] = { "Id", "Nome", "Preço", "Estoque"};
		
		tableModel = new DefaultTableModel(SnackController.getSnackObjList(), columns);
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		btAdd = new JButton("Adicionar lanche");
		btRemove = new JButton("Remover lanche");
		btUpdate = new JButton("Atualizar lanche");
		
		initFrame();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		btAdd.removeActionListener(this);
		btUpdate.removeActionListener(this);
		btRemove.removeActionListener(this);
		controlScreen.dispose();
		tableScreen.dispose();

		if (src == btAdd) {
			new SnackDetails();
		}
		if (src == btUpdate) {
			new SnackIdScreen(false);
		}
		if (src == btRemove) {
			new SnackIdScreen(true);
		}
	}
	
	public class SnackIdScreen implements ActionListener {
		private JFrame screen;
		private JLabel text;
		private JComboBox<Integer> box;
		private JButton btOption;
		private int optionId;
		private boolean removing;
		
		public SnackIdScreen(boolean removing) {
			this.screen = new JFrame();
			this.text = new JLabel("Selecione o id do lanche");
			this.box = new JComboBox<Integer>();
			this.btOption = new JButton("OK");
			this.removing = removing;
			for (int i = 0; i < SnackController.getListSize(); i++) {
				box.addItem(i);
			}
			
			box.setBounds(50, 30, 350, 40);
			box.setFont(f);
			
			text.setBounds(50, 70, 350, 40);
			text.setFont(f);
			
			btOption.setBounds(150, 110, 150, 30);
			btOption.setFont(f);
			
			screen.add(box);
			screen.add(text);
			screen.add(btOption);
			
			screen.setSize(450, 200);
			screen.setLocationRelativeTo(null);
			screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			screen.setLayout(null);
			screen.setVisible(true);	
			
			btOption.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			btOption.removeActionListener(this);
			if (src == btOption) {
				optionId = (int) box.getSelectedItem();
				screen.dispose();
				if (removing) {
					SnackController.remove(optionId);
					new SnackScreen();
				} else new SnackDetails(optionId);
			}
		}
	}
}
