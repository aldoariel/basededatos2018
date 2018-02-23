package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class InternalFrame2 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrame2 frame = new InternalFrame2();
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
	public InternalFrame2() {
		setToolTipText("Este es el Formulario interno2");
		setTitle("Este es el Formulario Interno2");
		setBounds(100, 100, 450, 300);

	}

}
