package jdbc.test;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import jdbc.controlador.CProducto;
import jdbc.controlador.IProducto;
import jdbc.modelo.Producto;

public class SalvaProducto {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager
				.getCrossPlatformLookAndFeelClassName());

		Producto producto = new Producto();

		String descripcion = JOptionPane.showInputDialog(null,
				"Descripcion del producto", "Registro de producto",
				JOptionPane.QUESTION_MESSAGE);

		if (descripcion != null) {
			producto.setDescripcion(descripcion);
			IProducto productoDAO = new CProducto();

			productoDAO.salvar(producto);
			System.out.println("Producto grabado con exito.");
		}
	}

}
