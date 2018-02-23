package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class InternalFrame1 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrame1 frame = new InternalFrame1();
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
	public InternalFrame1() {
		setToolTipText("Este es el Formulario interno1");
		setTitle("Este es el Formulario Interno1");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("New label");
		getContentPane().add(label, BorderLayout.CENTER);

	}

}
