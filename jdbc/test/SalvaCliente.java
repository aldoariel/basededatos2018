package jdbc.test;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import jdbc.controlador.ClienteDAO;
import jdbc.controlador.ICliente;
import jdbc.modelo.Cliente;

public class SalvaCliente {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager
				.getCrossPlatformLookAndFeelClassName());

		Cliente cliente = new Cliente();

		String nombre = JOptionPane.showInputDialog(null, "Nombre del cliente",
				"Registro de cliente", JOptionPane.QUESTION_MESSAGE);

		if (nombre != null) {
			cliente.setNombre(nombre);
			ICliente clienteDAO = new ClienteDAO();

			clienteDAO.insertar(cliente);
			System.out.println("Cliente grabado con exito.");
		}
	}

}
