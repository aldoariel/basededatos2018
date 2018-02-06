package jdbc.controlador;

import java.util.List;

import jdbc.modelo.Producto;

public interface IProducto {
	public void salvar(Producto producto);

	public Producto buscarPorCodigo(Long codigo);

	public List<Producto> buscarTodos();

}
