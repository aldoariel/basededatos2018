package jdbc.controlador;

import java.sql.Connection;

import jdbc.conexion.JdbcDAOFactory;

public abstract class ControladorAbstract {

	protected Connection connection;

	public ControladorAbstract() {
		super();
		this.obtenerConexion(null);
	}

	public ControladorAbstract(Connection connection) {
		super();
		this.obtenerConexion(connection);
	}

	private void obtenerConexion(Connection c) {
		if (c == null) {
			this.connection = JdbcDAOFactory.obtenerConeccion();
		} else {
			this.connection = connection;
		}
	}

}
