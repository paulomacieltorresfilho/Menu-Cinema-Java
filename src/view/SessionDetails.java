package view;

import javax.swing.*;
import controller.MovieController;
import controller.SessionController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SessionDetails implements ActionListener{
	
	private static int inputSize[] = {250, 25};
	private static int labelSize[] = {150, 25};
	private static int buttonsSize[] = {250, 65};
	private static int labelInputXDis = 30 + labelSize[0];
	private static Font f = new Font("Lucida Sans", Font.PLAIN, 15);

	private JFrame screen;
	private JLabel nameLabel;
	private JComboBox<String> nameInput;
	private JLabel roomLabel;
	private JComboBox<String> roomInput;
	private JLabel dateLabel;
	private JTextField dateInput; 
	private JLabel timeLabel;
	private JTextField timeInput;
	
	private JButton btSave;
	private JButton btCancel;
	
	private String[] sessionInfo;
	private int sessionId;
	private boolean updating;
	
	public void initFrame() {
		this.screen = new JFrame("");
		this.nameLabel = new JLabel("Filme:");
		this.nameInput = new JComboBox<String>(MovieController.getMovieNameList());
		this.roomLabel = new JLabel("Sala:");
		this.roomInput = new JComboBox<String>(SessionController.getRooms());
		this.dateLabel = new JLabel("Dia(02/04/2021):");
		this.dateInput = new JTextField("");
		this.timeLabel = new JLabel("Hora(15:00):");
		this.timeInput = new JTextField("");
		
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
		
		roomLabel.setBounds(30, 80,labelSize[0], labelSize[1]);
		roomInput.setBounds(labelInputXDis, 80, inputSize[0], inputSize[1]);
		roomLabel.setFont(f);
		roomInput.setFont(f);
		
		dateLabel.setBounds(30, 120,labelSize[0], labelSize[1]);
		dateInput.setBounds(labelInputXDis, 120, inputSize[0], inputSize[1]);
		dateLabel.setFont(f);
		dateInput.setFont(f);
		
		timeLabel.setBounds(30, 160,labelSize[0], labelSize[1]);
		timeInput.setBounds(labelInputXDis, 160, inputSize[0], inputSize[1]);
		timeLabel.setFont(f);
		timeInput.setFont(f);
		
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
		screen.add(roomLabel);
		screen.add(roomInput);
		screen.add(dateLabel);
		screen.add(dateInput);
		screen.add(timeLabel);
		screen.add(timeInput);

		screen.setLayout(null);
		screen.setSize(800, 265);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
	}
	
	public SessionDetails() {
		initFrame();
		updating = false;
		displayScreen();
	}
	
	public SessionDetails(int id) {
		initFrame();
		updating = true;
		this.sessionId = id;
		this.sessionInfo = SessionController.getSessionInfo(sessionId);
		
		nameInput.setSelectedItem(sessionInfo[0]);
		roomInput.setSelectedItem(sessionInfo[1]);
		dateInput.setText(sessionInfo[2]);
		timeInput.setText(sessionInfo[3]);
		displayScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btSave) {
			try {	
				btSave.removeActionListener(this);
				if (!updating) {
					SessionController.register(
						SessionController.createSession(
								(String)nameInput.getSelectedItem(),
								(String)roomInput.getSelectedItem(),
								(String)dateInput.getText(),
								(String)timeInput.getText())
					);
				} else {
					SessionController.update(
						this.sessionId, 
						SessionController.createSession(
							(String)nameInput.getSelectedItem(),
							(String)roomInput.getSelectedItem(),
							(String)dateInput.getText(),
							(String)timeInput.getText())
					);
				}
				Messages.registerSuccessMessage();
			} catch (Exception ex){
				Messages.registerErrorMessage();
			} finally {
				screen.dispose();
				new SessionScreen();
			}
		}
		if (src == btCancel) {
			btCancel.removeActionListener(this);
			Messages.operationCanceledMessage();
			new SessionScreen();	
			screen.dispose();
		}
	} 
}