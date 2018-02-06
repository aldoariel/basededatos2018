package jdbc.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.conexion.DAOException;
import jdbc.modelo.Dept;
import jdbc.modelo.Emp;

public class EmpDAO extends ControladorAbstract implements IEmp {

	public EmpDAO() {
		super();
	}

	public EmpDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void insertar(Emp emp) {
		try {
			String sql = String.format(
					"insert into emp (nombre,dept_id) values ('%s',%d)",
					emp.getNombre(), emp.getDept().getDept_id());

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
			// throw new DAOException("Errro al guardar cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public void modificar(Emp emp) {
		try {
			String sql = String.format(
					"update  emp set nombre='%s', dept_id=%d where dept_id=%d",
					emp.getNombre(), emp.getDept().getDept_id(),
					emp.getEmp_id());

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
			// throw new DAOException("Errro al guardar cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public void borrar(Long codigo) {
		try {
			String sql = String.format("delete from  emp where emp_id=%d",
					codigo);

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
			// throw new DAOException("Errro al guardar cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public Emp buscarPorCodigo(Long codigo) {
		Emp emp = null;
		try {
			String sql = String.format("select * from emp where emp_id = %d",
					codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Emp();
				emp.setEmp_id(rs.getLong("emp_id"));
				emp.setNombre(rs.getString("nombre"));
				Dept d1 = new Dept(rs.getLong("dept_id"), "");
				d1 = new DeptDAO().buscarPorCodigo(d1.getDept_id());
				emp.setDept(d1);
			}

		} catch (SQLException e) {
			// throw new DAOException("Error buscando cliente", e);
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return emp;
	}

	@Override
	public List<Emp> buscarTodos() {
		List<Emp> emps = new ArrayList<Emp>();
		try {
			String sql = "select * from emp";
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmp_id(rs.getLong("emp_id"));
				emp.setNombre(rs.getString("nombre"));
				Dept d1 = new Dept(rs.getLong("dept_id"), "");
				d1 = new DeptDAO().buscarPorCodigo(d1.getDept_id());
				emp.setDept(d1);

				emps.add(emp);
			}

		} catch (SQLException e) {
			throw new DAOException("Error buscando cliente", e);
		}

		finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return emps;
	}

	@Override
	public List<Emp> buscarPorCampo(String campo, String valor) {
		List<Emp> emps = new ArrayList<Emp>();
		try {
			String sql = String.format("select * from emp where %s ilike '%s'",
					campo, ("%" + valor + "%"));
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmp_id(rs.getLong("emp_id"));
				emp.setNombre(rs.getString("nombre"));
				Dept d1 = new Dept(rs.getLong("dept_id"), "");
				d1 = new DeptDAO().buscarPorCodigo(d1.getDept_id());
				emp.setDept(d1);

				emps.add(emp);
			}

		} catch (SQLException e) {
			throw new DAOException("Error buscando cliente", e);
		}

		finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return emps;
	}

}
