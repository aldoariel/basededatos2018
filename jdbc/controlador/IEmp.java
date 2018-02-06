package jdbc.controlador;

import java.util.List;

import jdbc.modelo.Emp;

public interface IEmp {

	public void insertar(Emp emp);

	public void modificar(Emp emp);

	public void borrar(Long codigo);

	public Emp buscarPorCodigo(Long codigo);

	public List<Emp> buscarTodos();

	public List<Emp> buscarPorCampo(String campo, String valor);

}
