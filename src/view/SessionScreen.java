package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

public class SessionScreen implements ActionListener{
	
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);
	
	private static JFrame screen = new JFrame("Lista de sessões");
	
	private static String columns [] = { "Filme", "Sala", "Dia", "Horário"};
	private static DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	private static JTable table = new JTable(tableModel);
	private static JScrollPane scrollPane = new JScrollPane(table);
	
	private static JButton btAdd = new JButton("Adicionar sessão");
	private static JButton btRemove = new JButton("Remover sessão");
	private static JButton btUpdate = new JButton("Atualizar sessão");
	

	
	SessionScreen() {
		
		tableModel.setRowCount(0);
		for (int i = 0; i < SessionController.getListSize(); i++) {
			String[] sessionInfo = SessionController.getSessionInfo(i);
			Object session [] = {
					sessionInfo[0], // Filme
					sessionInfo[1], // Sala
					sessionInfo[2], // Dia
					sessionInfo[3], // Horário
			};
			tableModel.addRow(session);
		}
		
		table.setEnabled(false);
		table.setBounds(30, 40, 200, 300);
		table.setFont(f);
		table.getTableHeader().setFont(f);
		
		btAdd.setBounds(50, 340, 200, 40);
		btAdd.setFont(f);
		btUpdate.setBounds(300, 340, 200, 40);
		btUpdate.setFont(f);
		btRemove.setBounds(550, 340, 200, 40);
		btRemove.setFont(f);
		
		screen.add(btAdd);
		screen.add(btRemove);
		screen.add(btUpdate);
		screen.add(scrollPane);
		
		
		screen.setSize(800, 440);
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btAdd.addActionListener(this);
		btUpdate.addActionListener(this);
		btRemove.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btAdd) {
			screen.dispose();
			new SessionDetails();
		}
		if (src == btUpdate) {
			screen.dispose();
			new SessionIdScreen();
		}
		if (src == btRemove) {
			new SessionIdScreen();
		}
	}
	
	public class SessionIdScreen implements ActionListener {
		private static JFrame screen = new JFrame();
		private static JLabel text = new JLabel("Escolha o id do filme que deseja atualizar");
		private static JComboBox<Integer> box = new JComboBox<Integer>();
		private static JButton btOption = new JButton("OK");
		private int optionId;
		

		public SessionIdScreen() {
			for (int i = 0; i < SessionController.getListSize(); i++) {
				box.addItem(i);
			}
			
			box.setBounds(50, 30, 350, 40);
			box.setFont(f);
			
			text.setBounds(50, 80, 350, 40);
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
			
			if (src == btOption) {
				optionId = (int) box.getSelectedItem();
				screen.setVisible(false);
				new SessionDetails(optionId);
			}
			
		}
		
	}
}
