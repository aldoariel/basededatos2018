package jdbc.conexion;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DAOException(String msg, Throwable t) {
		super(msg, t);

	}

}
