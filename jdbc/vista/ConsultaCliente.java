package vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import controlador.ClienteDAO;

public class ConsultaCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCliente frame = new ConsultaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 36, 384, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		TablaJTable model = new TablaJTable();
		cargarDatos(model);
		table.setModel(model);	
	}
	
	private void cargarDatos(TablaJTable model){
		List<Cliente> lc = new ClienteDAO().buscarTodos();
		//columnas
		String[] s = {"Id","Nombre"};
		model.setNombreColumna( s );
		//registros
		List<String[]> r = new ArrayList<String[]>();	
		for (Cliente cliente : lc) {
			
			String[] registros = {cliente.getCodigo().toString(),cliente.getNombre()};
			//String[] registros = {cliente.getNombre()};
			r.add(registros);
		}
		//cargar
		model.setRegistros(r);
	}
}
