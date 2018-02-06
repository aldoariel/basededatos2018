package jdbc.test;

import java.util.List;

import jdbc.controlador.DdlSql;
import jdbc.controlador.DeptDAO;
import jdbc.controlador.EmpDAO;
import jdbc.controlador.IDept;
import jdbc.modelo.Dept;
import jdbc.modelo.Emp;

public class TestDeptEm {

	public static void main(String[] args) {
		// crear la tabla
		new DdlSql().crearTablaDept();
		new DdlSql().crearTablaEmp();
		IDept deptDAO = new DeptDAO();

		// insertar
		Dept d1 = new Dept(0L, "Departamento1"); // new
		deptDAO.insertar(d1);

		Dept d2 = new Dept(0L, "Departamento 02"); // new
		deptDAO.insertar(d2);

		new DeptDAO().insertar(new Dept(0L, "Departamento3"));

		// modificar
		Dept d01 = new Dept(1L, "Departamento 01");
		new DeptDAO().modificar(d01);

		new DeptDAO().modificar(new Dept(2l, "Departamento 02"));

		new DeptDAO().modificar(new Dept(3l, "Departamento 03"));

		new DeptDAO().insertar(new Dept(0L, "borrar"));
		new DeptDAO().borrar(4l);
		new DeptDAO().borrar(5l);

		// mostrar buscarPorCodigo
		Dept d21 = new Dept();
		IDept cd21 = new DeptDAO();
		d21 = cd21.buscarPorCodigo(2L);
		System.out.println(d21);

		// listar todos
		System.out.println("** Lista **");
		List<Dept> depts1 = new DeptDAO().buscarTodos();
		for (Dept dept : depts1) {
			System.out.println(dept);
		}

		// listar con filtro
		System.out.println("** Lista con filtro **");
		List<Dept> dept2 = new DeptDAO().buscarPorCampo("nombre", "3");
		for (Dept dept : dept2) {
			System.out.println(dept);
		}

		// inserta
		Emp e1 = new Emp(0L, "Juan Perez", new Dept(1l, ""), null);
		new EmpDAO().insertar(e1);

		Emp e2 = new Emp(0L, "Pedro Benitez", new Dept(2l, ""), null);
		new EmpDAO().insertar(e2);

		// modifcar
		Emp e3 = new Emp(2L, "Pedro Benitez modi", new Dept(3l, ""), null);
		new EmpDAO().modificar(e3);

		// borar
		Emp e4 = new Emp(0L, "borrar", new Dept(1l, ""), null);
		new EmpDAO().insertar(e4);
		new EmpDAO().borrar(3L);

		// mostrar por codigo
		Emp e01 = new EmpDAO().buscarPorCodigo(1L);
		System.out.println(e01);

		// listar todos
		System.out.println("** Lista Empleado **");
		List<Emp> emps = new EmpDAO().buscarTodos();
		for (Emp emp : emps) {
			System.out.println(emp);
		}

		// listar con filtro
		System.out.println("** Lista con filtro Empleado **");
		List<Emp> emp2s = new EmpDAO().buscarPorCampo("nombre", "Juan");
		for (Emp emp : emp2s) {
			System.out.println(emp);
		}

	}

}
