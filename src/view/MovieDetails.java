package view;

import javax.swing.*;

import controller.MovieController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Movie;

public class MovieDetails implements ActionListener{
	
	private static int inputSize[] = {250, 25};
	private static int labelSize[] = {150, 25};
	private static int buttonsSize[] = {250, 65};
	private static int labelInputXDis = 30 + labelSize[0];
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);

	private JFrame screen = new JFrame("");
	private JLabel nameLabel = new JLabel("Nome:");
	private JTextField nameInput = new JTextField("");
	private JLabel synopsisLabel = new JLabel("Sinopse:");
	private JTextField synopsisInput = new JTextField("");
	private JLabel genreLabel = new JLabel("Gênero:");
	private JTextField genreInput = new JTextField("");
	private JLabel durationLabel = new JLabel("Duração (min):");
	private JTextField durationInput = new JTextField("");
	
	private static JButton btSave = new JButton("Salvar");
	private static JButton btCancel = new JButton("Cancelar");
	
	private Movie movie;
	private boolean updating;
	
	public void displayScreen() {
		
		nameLabel.setBounds(30, 40,labelSize[0], labelSize[1]);
		nameInput.setBounds(labelInputXDis, 40, inputSize[0], inputSize[1]);
		nameLabel.setFont(f);
		nameInput.setFont(f);
		
		synopsisLabel.setBounds(30, 80,labelSize[0], labelSize[1]);
		synopsisInput.setBounds(labelInputXDis, 80, inputSize[0], inputSize[1]);
		synopsisLabel.setFont(f);
		synopsisInput.setFont(f);
		
		genreLabel.setBounds(30, 120,labelSize[0], labelSize[1]);
		genreInput.setBounds(labelInputXDis, 120, inputSize[0], inputSize[1]);
		genreLabel.setFont(f);
		genreInput.setFont(f);
		
		durationLabel.setBounds(30, 160,labelSize[0], labelSize[1]);
		durationInput.setBounds(labelInputXDis, 160, inputSize[0], inputSize[1]);
		durationLabel.setFont(f);
		durationInput.setFont(f);
		
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
		screen.add(synopsisLabel);
		screen.add(synopsisInput);
		screen.add(genreLabel);
		screen.add(genreInput);
		screen.add(durationLabel);
		screen.add(durationInput);

		screen.setLayout(null);
		screen.setSize(800, 265);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
		
		btSave.addActionListener(this);
		btCancel.addActionListener(this);
	}
	
	public MovieDetails() {
		updating = false;
		displayScreen();
	}
	public MovieDetails(int id) {
		updating = true;
		movie = MovieController.getMovie(id);
		nameInput.setText(movie.getName());
		synopsisInput.setText(movie.getSynopsis());
		genreInput.setText(movie.getGenre());
		durationInput.setText(Integer.toString(movie.getDuration()));
		displayScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btSave) {
			try {	

				movie = new Movie(
						nameInput.getText(),
						synopsisInput.getText(),
						genreInput.getText(),
						Integer.parseInt(durationInput.getText()));
				
				if (!updating) {
					MovieController.register(movie);
				}
				
//				registerSuccessMessage();
				screen.dispose();
				new MovieScreen();	
			} catch (Exception ex){
//				registerErrorMessage();
			}
		}
		if (src == btCancel) {
//			operationCanceledMessage();
			screen.dispose();
			new MovieScreen();	
		}
		
	}
	
}
