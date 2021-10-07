package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MovieController;

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
	
	public MovieScreen() {
		
		tableModel.setRowCount(0);
		for (int i = 0; i < MovieController.getListSize(); i++) {
			String[] movieInfo = MovieController.getMovieInfo(i);
			Object movie [] = {
					i, 
					movieInfo[0],
					movieInfo[2],
					movieInfo[3]
			};
			tableModel.addRow(movie);
		}

		table.setLocation(30, 40);
		table.setPreferredSize(new Dimension(200, 300));
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
		btAdd.removeActionListener(this);
		btUpdate.removeActionListener(this);
		btRemove.removeActionListener(this);
		screen.dispose();
		
		if (src == btAdd) {
			new MovieDetails();
		}
		if (src == btUpdate) {
			new MovieIdScreen(false);
		}
		if (src == btRemove) {
			new MovieIdScreen(true);
		}
	}
	
	public class MovieIdScreen implements ActionListener {
		private JFrame screen;
		private JLabel text;
		private JComboBox<Integer> box;
		private JButton btOption;
		private int optionId;
		private boolean removing;

		public MovieIdScreen(boolean removing) {
			this.screen = new JFrame();
			this.text = new JLabel("Selecione o id do filme");
			this.box = new JComboBox<Integer>();
			this.btOption = new JButton("OK");
			this.removing = removing;
			
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
			btOption.removeActionListener(this);
			if (src == btOption) {
				optionId = (int) box.getSelectedItem();
				screen.dispose();
				if (removing) {
					MovieController.remove(optionId);
					new MovieScreen();
				} else new MovieDetails(optionId);	
			}
		}
	}
}
