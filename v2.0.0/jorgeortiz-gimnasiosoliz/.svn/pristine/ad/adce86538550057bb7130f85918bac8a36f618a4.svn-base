package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 20/02/2019
 * Nota: Mantenimiento para Ejercicio.
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 
 * 
 */
@Entity
public class Ejercicio {

	@Id
	@SequenceGenerator(name="ejer_generator", initialValue=1, allocationSize = 1,  sequenceName="ejer_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ejer_generator")
	@NotNull
	@Column(name = "ejer_id")
	private int idEjercicio;
	
	@Column(name = "ejer_nombre")
	private String nombre;
	
	@Column(name = "ejer_series")
	private int series;
	
	@Column(name = "ejer_repeticiones")
	private String repeticiones; //10-8-8-8

	public int getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public String getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(String repeticiones) {
		this.repeticiones = repeticiones;
	}
	
	
}
