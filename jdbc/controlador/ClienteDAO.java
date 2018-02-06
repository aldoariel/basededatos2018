package jdbc.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.conexion.DAOException;
import jdbc.modelo.Cliente;

public class ClienteDAO extends ControladorAbstract implements ICliente {

	public ClienteDAO() {
		super();
	}

	public ClienteDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void insertar(Cliente cliente) {
		try {
			String sql = String.format(
					"insert into cliente (nombre) values ('%s')",
					cliente.getNombre());

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
	public void modificar(Cliente cliente) {
		try {
			String sql = String.format(
					"update  cliente set nombre='%s' where codigo=%d",
					cliente.getNombre(), cliente.getCodigo());

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
			String sql = String.format("delete from  cliente where codigo=%d",
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
	public Cliente buscarPorCodigo(Long codigo) {
		Cliente cliente = null;
		try {
			String sql = String.format(
					"select * from cliente where codigo = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNombre(rs.getString("nombre"));
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

		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String sql = "select * from cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNombre(rs.getString("nombre"));

				clientes.add(cliente);
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
	public List<Cliente> buscarPorCampo(String campo, String valor) {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String sql = String.format(
					"select * from cliente where %s ilike '%s'", campo, ("%"
							+ valor + "%"));
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNombre(rs.getString("nombre"));

				clientes.add(cliente);
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

}
