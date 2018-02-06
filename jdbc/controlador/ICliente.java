package jdbc.controlador;

import java.util.List;

import jdbc.modelo.Cliente;

public interface ICliente {
	public void insertar(Cliente cliene);

	public void modificar(Cliente cliente);

	public void borrar(Long codigo);

	public Cliente buscarPorCodigo(Long codigo);

	public List<Cliente> buscarTodos();

	public List<Cliente> buscarPorCampo(String campo, String valor);

}
