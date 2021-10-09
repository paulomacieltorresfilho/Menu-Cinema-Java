package view;

import javax.swing.JOptionPane;

public class Messages {
	
	public static void registerSuccessMessage() {
		JOptionPane.showMessageDialog(null, "Sucesso");
	}
	
	public static void registerErrorMessage() {
		JOptionPane.showConfirmDialog(null, "Dados inválidos, verifique se tudo foi digitado corretamente", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
	}

	public static void operationCanceledMessage() {
		JOptionPane.showMessageDialog(null, "Operação cancelada");
	}
}
