package jdbc.modelo;

import java.util.Date;

public class Emp {

	private Long emp_id;
	private String nombre;
	private Dept dept;

	public Emp() {
		super();
	}

	public Emp(Long emp_id, String nombre, Dept dept, Date ingreso) {
		super();
		this.emp_id = emp_id;
		this.nombre = nombre;
		this.dept = dept;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
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
		Emp other = (Emp) obj;
		if (emp_id == null) {
			if (other.emp_id != null)
				return false;
		} else if (!emp_id.equals(other.emp_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [emp_id=" + emp_id + ", nombre=" + nombre + ", dept="
				+ dept + "]";
	}

}
