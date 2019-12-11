package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ejer_id")
	private Integer ejerId = 0;

	@Column(name="ejer_nombre")
	private String ejerNombre;

	@Column(name="ejer_repeticiones")
	private String ejerRepeticiones;

	@Column(name="ejer_series")
	private Integer ejerSeries;

	@Column(name="per_id")
	private Integer perId;

	@Column(name="rut_id")
	private Integer rutId;

	public Ejercicio() {
	}

	public Integer getEjerId() {
		return this.ejerId;
	}

	public void setEjerId(Integer ejerId) {
		this.ejerId = ejerId;
	}

	public String getEjerNombre() {
		return this.ejerNombre;
	}

	public void setEjerNombre(String ejerNombre) {
		this.ejerNombre = ejerNombre;
	}

	public String getEjerRepeticiones() {
		return this.ejerRepeticiones;
	}

	public void setEjerRepeticiones(String ejerRepeticiones) {
		this.ejerRepeticiones = ejerRepeticiones;
	}

	public Integer getEjerSeries() {
		return this.ejerSeries;
	}

	public void setEjerSeries(Integer ejerSeries) {
		this.ejerSeries = ejerSeries;
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public Integer getRutId() {
		return this.rutId;
	}

	public void setRutId(Integer rutId) {
		this.rutId = rutId;
	}

}