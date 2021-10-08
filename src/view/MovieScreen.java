package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MovieController;

public class MovieScreen implements ActionListener{
	
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);
	
	private JFrame tableScreen = new JFrame("Lista de filmes");
	private JFrame controlScreen = new JFrame("Controlador");
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JPanel filterPanel;
	private JComboBox<String> filterBox;
	private JButton btFilter;
	
	private JButton btAdd;
	private JButton btRemove;
	private JButton btUpdate;
	
	public void initFrame() {
		btAdd.setBounds(50, 20, 200, 40);
		btAdd.setFont(f);
		btUpdate.setBounds(300, 20, 200, 40);
		btUpdate.setFont(f);
		btRemove.setBounds(550, 20, 200, 40);
		btRemove.setFont(f);
		
		filterBox.setBounds(75, 0, 250, 30);
		filterBox.setFont(f);
		btFilter.setBounds(135, 30, 125, 30);
		btFilter.setFont(f);
		
		filterPanel.add(filterBox);
		filterPanel.add(btFilter);
		
		filterPanel.setLayout(null);
		filterPanel.setBounds(200, 80, 400, 60);
		
		controlScreen.add(btAdd);
		controlScreen.add(btRemove);
		controlScreen.add(btUpdate);
		controlScreen.add(filterPanel);
		
		controlScreen.setLayout(null);
		controlScreen.setSize(800, 200);
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
		controlScreen.setLocation((int)tableScreen.getLocation().getX(), (int)tableScreen.getLocation().getY() - 200);
		
		btAdd.addActionListener(this);
		btUpdate.addActionListener(this);
		btRemove.addActionListener(this);
		btFilter.addActionListener(this);
		
	}
	
	public MovieScreen() {
		
		String columns [] = { "Id", "Nome", "Gênero", "Duração (min)"};
		
		tableModel = new DefaultTableModel(MovieController.getMovieObjList(), columns);
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		filterPanel = new JPanel();
		filterBox = new JComboBox<String>(MovieController.getGenreList());
		btFilter = new JButton("aplicar filtro");
		btAdd = new JButton("Adicionar filme");
		btRemove = new JButton("Remover filme");
		btUpdate = new JButton("Atualizar filme");
		
		initFrame();
		
	}
	
	public MovieScreen(String genre) {
		
		String columns [] = { "Id", "Nome", "Gênero", "Duração (min)"};
		
		tableModel = new DefaultTableModel(MovieController.getMovieObjList(genre), columns);
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		filterPanel = new JPanel();
		filterBox = new JComboBox<String>(MovieController.getGenreList());
		btFilter = new JButton("aplicar filtro");
		btAdd = new JButton("Adicionar filme");
		btRemove = new JButton("Remover filme");
		btUpdate = new JButton("Atualizar filme");
		
		initFrame();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		btAdd.removeActionListener(this);
		btUpdate.removeActionListener(this);
		btRemove.removeActionListener(this);
		btFilter.removeActionListener(this);
		controlScreen.dispose();
		tableScreen.dispose();
		
		if (src == btAdd) {
			new MovieDetails();
		}
		if (src == btUpdate) {
			new MovieIdScreen(false);
		}
		if (src == btRemove) {
			new MovieIdScreen(true);
		}
		if (src == btFilter) {
			tableModel.setNumRows(0);
			new MovieScreen((String)filterBox.getSelectedItem());
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
					MovieController.remove(optionId);
					new MovieScreen();
				} else new MovieDetails(optionId);	
			}
		}
	}
}
