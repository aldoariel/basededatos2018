package jdbc.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.conexion.DAOException;
import jdbc.conexion.JdbcDAOFactory;
import jdbc.modelo.Producto;

public class CProducto implements IProducto {

	private Connection connection;

	public CProducto() {
		super();
		this.connection = new JdbcDAOFactory().obtenerConeccion();
	}

	public CProducto(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void salvar(Producto producto) {
		try {
			String sql = String.format(
					"insert into producto (descripcion) values ('%s')",
					producto.getDescripcion());

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Errro al guardar producto", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public Producto buscarPorCodigo(Long codigo) {
		Producto producto = null;

		try {
			String sql = String.format(
					"select * from producto where codigo = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setCodigo(rs.getLong("codigo"));
				producto.setDescripcion(rs.getString("descripcion"));
			}

		} catch (SQLException e) {
			throw new DAOException("Error buscando producto", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return producto;
	}

	@Override
	public List<Producto> buscarTodos() {
		List<Producto> productos = new ArrayList<Producto>();
		try {
			String sql = "select * from producto";
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setCodigo(rs.getLong("codigo"));
				producto.setDescripcion(rs.getString("descripcion"));

				productos.add(producto);
			}

		} catch (SQLException e) {
			throw new DAOException("Error buscando producto", e);
		}

		finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return productos;
	}

}
