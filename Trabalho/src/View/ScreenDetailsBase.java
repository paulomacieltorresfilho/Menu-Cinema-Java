package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public abstract class ScreenDetailsBase {
	protected JFrame menu = new JFrame("");
	protected JLabel lL1 = new JLabel("");
	protected JTextField l1 = new JTextField();
	protected JLabel lL2 = new JLabel("");
	protected JTextField l2 = new JTextField();
	protected JLabel lL3 = new JLabel("");
	protected JTextField l3 = new JTextField();
	protected JLabel lL4 = new JLabel("");
	protected JTextField l4 = new JTextField();
	protected JLabel lL5 = new JLabel("");
	protected JTextField l5 = new JTextField();
	protected JButton save  = new JButton("Salvar");
	protected JButton remove = new JButton("Excluir");
	
	public ScreenDetailsBase() {
		//label
		lL1.setBounds(20,10,150,30);
		lL2.setBounds(20,40,150,30);
		lL3.setBounds(20,70,150,30);
		lL4.setBounds(20,100,150,30);
		lL5.setBounds(20,130,150,30);
		
		menu.add(lL1);
		menu.add(lL2);
		menu.add(lL3);
		menu.add(lL4);
		menu.add(lL5);
		
		//textField
		l1.setBounds(100, 10, 150,30);
		l2.setBounds(100, 40, 150,30);
		l3.setBounds(100, 70, 150,30);
		l4.setBounds(100, 100, 150,30);
		l5.setBounds(100, 130, 150,30);
		
		menu.add(l1);
		menu.add(l2);
		menu.add(l3);
		menu.add(l4);
		menu.add(l5);

		//button
		save.setBounds(70,177,100,30);
		remove.setBounds(200,177,100,30);
		
		menu.add(save);
		menu.add(remove);
		
		//frame
		menu.setLayout(null);
		menu.setSize(400,250);
		menu.setLocation(0, 550);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setVisible(true);
	}
	
	public void messageRemove() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", "Sucesso", 
				JOptionPane.INFORMATION_MESSAGE);
		menu.dispose();
	}
	public void messageSave() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", "Sucesso", 
				JOptionPane.INFORMATION_MESSAGE);
		menu.dispose();
	}
	public void massageErroRegister() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. id e dura��o n�o cont�m apenas n�meros", "Menssagem de ERRO", 
				JOptionPane.ERROR_MESSAGE);
	}

	
}
