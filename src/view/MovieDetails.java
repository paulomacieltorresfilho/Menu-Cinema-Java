package view;

import javax.swing.*;
import controller.MovieController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieDetails implements ActionListener{
	
	private static int inputSize[] = {250, 25};
	private static int labelSize[] = {150, 25};
	private static int buttonsSize[] = {250, 65};
	private static int labelInputXDis = 30 + labelSize[0];
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);

	private JFrame screen;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JLabel synopsisLabel;
	private JTextField synopsisInput;
	private JLabel genreLabel;
	private JComboBox<String> genreInput;
	private JLabel durationLabel;
	private JTextField durationInput;
	
	private JButton btSave;
	private JButton btCancel;
	
	private String[] movieInfo;
	private int movieId;
	private boolean updating;
	
	public void initFrame() {
		this.screen = new JFrame("");
		this.nameLabel = new JLabel("Nome:");
		this.nameInput = new JTextField("");
		this.synopsisLabel = new JLabel("Sinopse:");
		this.synopsisInput = new JTextField("");
		this.genreLabel = new JLabel("Gênero:");
		this.genreInput = new JComboBox<String>(MovieController.getGenreList());
		this.durationLabel = new JLabel("Duração (min):");
		this.durationInput = new JTextField("");
		
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
	}
	
	public MovieDetails() {
		initFrame();
		updating = false;
		displayScreen();
	}
	
	public MovieDetails(int id) {
		initFrame();
		updating = true;
		this.movieInfo = MovieController.getMovieInfo(id);
		this.movieId = id;
		
		nameInput.setText(movieInfo[0]);
		synopsisInput.setText(movieInfo[1]);
		genreInput.setSelectedItem(movieInfo[2]);
		durationInput.setText(movieInfo[3]);
		displayScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btSave) {
			try {	
				btSave.removeActionListener(this);
				if (!updating) {
					MovieController.register(
						MovieController.createMovie(
								nameInput.getText(),
								synopsisInput.getText(),
								(String)genreInput.getSelectedItem(),
								Integer.parseInt(durationInput.getText()))
					);
				} else {
					MovieController.update(
						this.movieId, 
						MovieController.createMovie(
							nameInput.getText(),
							synopsisInput.getText(),
							(String)genreInput.getSelectedItem(),
							Integer.parseInt(durationInput.getText()))
					);
				}
//				registerSuccessMessage();
			} catch (Exception ex){
//				registerErrorMessage();
			} finally {
				screen.dispose();
				new MovieScreen();
			}
		}
		if (src == btCancel) {
			btCancel.removeActionListener(this);
//			operationCanceledMessage();
			new MovieScreen();	
			screen.dispose();
		}
	}
}
