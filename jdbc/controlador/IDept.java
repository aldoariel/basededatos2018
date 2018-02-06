package jdbc.controlador;

import java.util.List;

import jdbc.modelo.Dept;

public interface IDept {

	public void insertar(Dept dept);

	public void modificar(Dept dept);

	public void borrar(Long codigo);

	public Dept buscarPorCodigo(Long codigo);

	public List<Dept> buscarTodos();

	public List<Dept> buscarPorCampo(String campo, String valor);

}
