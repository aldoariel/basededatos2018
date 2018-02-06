package jdbc.modelo;

public class Dept {
	
	private Long dept_id;
	private String nombre;
	
	
	public Dept() {
		super();
	}


	public Dept(Long dept_id, String nombre) {
		super();
		this.dept_id = dept_id;
		this.nombre = nombre;
	}


	public Long getDept_id() {
		return dept_id;
	}


	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept_id == null) ? 0 : dept_id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		if (dept_id == null) {
			if (other.dept_id != null)
				return false;
		} else if (!dept_id.equals(other.dept_id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Dept [dept_id=" + dept_id + ", nombre=" + nombre + "]";
	}
	
}
