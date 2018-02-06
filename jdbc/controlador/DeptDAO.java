package jdbc.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.conexion.DAOException;
import jdbc.modelo.Dept;

public class DeptDAO extends ControladorAbstract implements IDept {

	public DeptDAO() {
		super();
	}

	public DeptDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void insertar(Dept dept) {
		try {
			String sql = String
					.format("insert into dept (nombre) values ('%s')",
							dept.getNombre());

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
	public void modificar(Dept dept) {
		try {
			String sql = String.format(
					"update  dept set nombre='%s' where dept_id=%d",
					dept.getNombre(), dept.getDept_id());

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
		// TODO Auto-generated method stub
		try {
			String sql = String.format("delete from  dept where dept_id=%d",
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
	public Dept buscarPorCodigo(Long codigo) {
		Dept dept = null;
		try {
			String sql = String.format("select * from dept where dept_id = %d",
					codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dept = new Dept();
				dept.setDept_id(rs.getLong("dept_id"));
				dept.setNombre(rs.getString("nombre"));
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

		return dept;
	}

	@Override
	public List<Dept> buscarTodos() {
		List<Dept> clientes = new ArrayList<Dept>();
		try {
			String sql = "select * from dept";
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDept_id(rs.getLong("dept_id"));
				dept.setNombre(rs.getString("nombre"));

				clientes.add(dept);
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

		return clientes;
	}

	@Override
	public List<Dept> buscarPorCampo(String campo, String valor) {
		// TODO Auto-generated method stub
		List<Dept> depts = new ArrayList<Dept>();
		try {
			String sql = String.format(
					"select * from dept where %s ilike '%s'", campo, ("%"
							+ valor + "%"));
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDept_id(rs.getLong("dept_id"));
				dept.setNombre(rs.getString("nombre"));

				depts.add(dept);
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

		return depts;
	}

}
