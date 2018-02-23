package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import controlador.ClienteDAO;

public class FormularioCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfcodigo;
	private JTextField tfnombre;
	
	private String abrir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioCliente frame = new FormularioCliente();
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
	public FormularioCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 344, 408);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionarRegistro(abrir);
			}


		});
		scrollPane.setViewportView(table);
		
		//TablaJTable model = new TablaJTable();
		cargarDatos();
		//table.setModel(model);	
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
				
			}
		});
		btnNewButton.setBounds(364, 74, 99, 32);
		contentPane.add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrar();
			}
		});
		btnEliminar.setBounds(364, 131, 99, 32);
		contentPane.add(btnEliminar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnGuardar.setBounds(478, 318, 99, 32);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
				cargarDatos();
			}
		});
		btnCancelar.setBounds(576, 318, 99, 32);
		contentPane.add(btnCancelar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(674, 318, 99, 32);
		contentPane.add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(478, 36, 302, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 43, 46, 14);
		panel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 93, 46, 14);
		panel.add(lblNombre);
		
		tfcodigo = new JTextField();
		tfcodigo.setEnabled(false);
		tfcodigo.setBounds(87, 40, 86, 20);
		panel.add(tfcodigo);
		tfcodigo.setColumns(10);
		
		tfnombre = new JTextField();
		tfnombre.setBounds(87, 90, 86, 20);
		panel.add(tfnombre);
		tfnombre.setColumns(10);
	}
	
	private void cargarDatos(){
		TablaJTable model = new TablaJTable();
	
		
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
		
		
		table.setModel(model);
	}
	
	
	private void seleccionarRegistro(String abrir) {
		// TODO Auto-generated method stub
		Integer fila = this.table.getSelectedRow();
		String xcodigo = String.valueOf(this.table.getValueAt( fila, 0 ));
		String xnombre = String.valueOf(this.table.getValueAt( fila, 1 ));
		this.tfcodigo.setText( xcodigo );  //cargamos el valor de dato en el campo codigo
		tfnombre.setText( xnombre );  //cargamos el valor de dato en el campo codigo
		
	}
	
	private void guardar(){
		Cliente cliente = new Cliente();
		//si el codigo es celro
		if( this.tfcodigo.getText().length() == 0 ){
			cliente.setCodigo(0L);
		}else{
			cliente.setCodigo((long) Integer.parseInt(this.tfcodigo.getText()) );
		}
		cliente.setNombre(this.tfnombre.getText());
		
		//validar
		if(this.tfnombre.getText().length() == 0){
			JOptionPane.showMessageDialog(null, "Nombre es obligatorio", "Aviso", 1);
			this.tfnombre.requestFocus();
		}else{
			//guardar
			boolean esNuevo = cliente.getCodigo()==0;
			if(esNuevo){
				//insertar
				new ClienteDAO().insertar(cliente);	
				JOptionPane.showMessageDialog(null, "Registro ha sido guardado", "Exito", 1);
			}else{
				//modificar
				new ClienteDAO().modificar(cliente);
				JOptionPane.showMessageDialog(null, "Registro ha sido guardado", "Exito", 1);
			}
			
			//cargar la tabla
			this.cargarDatos();
		}
		
	}
	
	private void borrar(){
		Cliente cliente = new Cliente();
		//si el codigo es celro
		if( this.tfcodigo.getText().length() == 0 ){
			cliente.setCodigo(0L);
		}else{
			cliente.setCodigo((long) Integer.parseInt(this.tfcodigo.getText()) );
		}	
		
		//validar
		if(this.tfcodigo.getText().length() == 0){
			JOptionPane.showMessageDialog(null, "Seleccione un registro", "Aviso", 1);
		}else{
		//borrar
			new ClienteDAO().borrar(cliente.getCodigo());
			JOptionPane.showMessageDialog(null, "Registro ha sido borrado", "Exito", 1);
		}

		//cargar la tabla
		this.cargarDatos();
		
		nuevo();
		
	}

	private void nuevo() {
		tfcodigo.setText( "" );  //cargamos el valor de dato en el campo codigo
		tfnombre.setText( "" );  //cargamos el valor de dato en el campo codigo
	}
}
