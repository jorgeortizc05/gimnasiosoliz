package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rutina database table.
 * 
 */
@Entity
@NamedQuery(name="Rutina.findAll", query="SELECT r FROM Rutina r")
public class Rutina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rut_id")
	private Integer rutId = 0;

	@Column(name="rut_descripcion")
	private String rutDescripcion;

	@Column(name="rut_nombre")
	private String rutNombre;

	public Rutina() {
	}

	public Integer getRutId() {
		return this.rutId;
	}

	public void setRutId(Integer rutId) {
		this.rutId = rutId;
	}

	public String getRutDescripcion() {
		return this.rutDescripcion;
	}

	public void setRutDescripcion(String rutDescripcion) {
		this.rutDescripcion = rutDescripcion;
	}

	public String getRutNombre() {
		return this.rutNombre;
	}

	public void setRutNombre(String rutNombre) {
		this.rutNombre = rutNombre;
	}

}