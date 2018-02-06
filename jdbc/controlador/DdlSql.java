package jdbc.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.conexion.DAOException;

public class DdlSql extends ControladorAbstract {

	public DdlSql() {
		super();
	}

	public DdlSql(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public void crearTablaDept() {
		try {
			String sql = String.format("CREATE TABLE dept ( "
					+ "dept_id serial NOT NULL," + "nombre character varying,"
					+ "CONSTRAINT dept_pkey PRIMARY KEY (dept_id)" + ")"
					+ " WITH (OIDS=FALSE); " + " ALTER TABLE dept "
					+ " OWNER TO postgres;"

			);

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
	}

	public void crearTablaEmp() {
		try {
			String sql = String.format("CREATE TABLE emp ( "
					+ " emp_id serial NOT NULL, "
					+ " nombre character varying, " + " dept_id integer, "
					+ "  " + " CONSTRAINT emp_pkey PRIMARY KEY (emp_id), "
					+ " CONSTRAINT emp_dept_id_fkey FOREIGN KEY (dept_id) "
					+ " REFERENCES dept (dept_id) MATCH SIMPLE "
					+ " ON UPDATE CASCADE ON DELETE CASCADE " + " ) "
					+ " WITH ( " + " OIDS=FALSE " + " ); "
					+ " ALTER TABLE emp " + " OWNER TO postgres; "

			);

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
	}

}
