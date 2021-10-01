package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

public class MovieScreen implements ActionListener{
	
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);
	
	private static JFrame screen = new JFrame("Lista de filmes");
	
	private static String columns [] = { "Id", "Nome", "Gênero", "Duração (min)"};
	private static DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	private static JTable table = new JTable(tableModel);
	private static JScrollPane scrollPane = new JScrollPane(table);
	
	private static JButton btAdd = new JButton("Adicionar filme");
	private static JButton btRemove = new JButton("Remover filme");
	private static JButton btUpdate = new JButton("Atualizar filme");
	

	
	MovieScreen() {
		
		tableModel.setRowCount(0);
		for (int i = 0; i < MovieController.getListSize(); i++) {
			Object movie [] = {
					i, 
					MovieController.getMovie(i).getName(),
					MovieController.getMovie(i).getGenre(),
					Integer.toString(MovieController.getMovie(i).getDuration())
			};
			tableModel.addRow(movie);
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
			new MovieDetails();
		}
		if (src == btUpdate) {
			screen.dispose();
			new MovieIdScreen();
		}
		if (src == btRemove) {
			new MovieIdScreen();
		}
	}
	
	public class MovieIdScreen implements ActionListener {
		private static JFrame screen = new JFrame();
		private static JLabel text = new JLabel("Escolha o id filme que deseja atualizar");
		private static JComboBox<Integer> box = new JComboBox<Integer>();
		private static JButton btOption = new JButton("OK");
		private int optionId;
		

		public MovieIdScreen() {
			for (int i = 0; i < MovieController.getListSize(); i++) {
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
				new MovieDetails(optionId);
			}
			
		}
		
	}
}
