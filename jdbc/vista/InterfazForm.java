package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfazForm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazForm frame = new InterfazForm();
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
	public InterfazForm() {
		setMaximumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 398);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciar formulario
				InternalFrame1 if1= new InternalFrame1();
				if1.setVisible(true);
				
				
				//remover
				desktopPane.removeAll();
				
				//redibujar
				desktopPane.repaint();
				
				
				//agregar el formulario								
				desktopPane.add(if1);		
				
			}
		});
		mnNewMenu.add(mntmClientes);
		
		JMenuItem mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cargar formulario
				InternalFrame2 if2 = new InternalFrame2();
				if2.setVisible(true);
				
				
				//remover
				desktopPane.removeAll();
				
				//redibujar
				desktopPane.repaint();
				
				//agregar el formulario		
				desktopPane.add(if2);

				
			}
		});
		mnNewMenu.add(mntmProductos);
		
		JMenuItem mntmDepartamentos = new JMenuItem("Departamentos");
		mnNewMenu.add(mntmDepartamentos);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mnNewMenu.add(mntmEmpleados);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmSalir);
		
		JMenu mnNewMenu_1 = new JMenu("Movimientos");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Informes");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciar formulario
				InternalFrame1 if1= new InternalFrame1();
				if1.setVisible(true);
					
				//remover
				desktopPane.removeAll();
				
				//redibujar
				desktopPane.repaint();
				
				
				//agregar el formulario								
				desktopPane.add(if1);	
			}
		});
		toolBar.add(btnClientes);
		
		JButton btnNewButton_1 = new JButton("Movimientos");
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(btnNewButton_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setMaximumSize(new Dimension(5, 32767));
		separator_2.setPreferredSize(new Dimension(0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(btnSalir);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
			
		
	}
}
