package jdbc.test;

import java.util.List;

import jdbc.controlador.ClienteDAO;
import jdbc.controlador.ICliente;
import jdbc.modelo.Cliente;

public class VerClientes {

	public static void main(String[] args) {

		Cliente c1 = new Cliente();
		c1.setCodigo(5L);

		ICliente c = new ClienteDAO();
		c1 = c.buscarPorCodigo(c1.getCodigo());

		System.out.println(c1);

		Cliente c2 = new Cliente();
		c2 = new ClienteDAO().buscarPorCodigo(6L);
		System.out.println(c2);
		
		  //insertar 
		Cliente c5 = new Cliente(0L,"Pedro Nuevo"); new
		ClienteDAO().insertar(c5);
		
		 
		 Cliente c3 = new ClienteDAO().buscarPorCodigo(3L); //
		 c3 = new ClienteDAO().buscarPorCodigo(8L); 
		 System.out.println(c3); //modificar
		 c3.setNombre("Pedro **"); 
		 new ClienteDAO().modificar(c3);
		 System.out.println(c3);
		 
		  //borar registro
		 new ClienteDAO().borrar(14L);
		 

		// listar todos
		System.out.println("** Lista **");
		List<Cliente> lc = new ClienteDAO().buscarTodos();
		for (Cliente cliente : lc) {
			System.out.println(cliente);
		}

		Cliente c4 = new Cliente();
		c4 = c.buscarPorCodigo(10L);

		// listar con filtro
		System.out.println("** Lista con filtro **");
		List<Cliente> lc2 = new ClienteDAO().buscarPorCampo("nombre", "Ped");
		for (Cliente cliente : lc2) {
			System.out.println(cliente);
		}

	}
}
