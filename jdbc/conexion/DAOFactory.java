package jdbc.conexion;

public abstract class DAOFactory {

	public DAOFactory getDAOFactory() {
		return new JdbcDAOFactory();
	}
}
