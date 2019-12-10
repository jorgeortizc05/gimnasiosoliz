package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 20/02/2019
 * Nota: Mantenimiento para Rutina.
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 
 */
@Entity
public class Rutina {

	@Id
	@SequenceGenerator(name="rut_generator", initialValue=1, allocationSize = 1,  sequenceName="rut_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "rut_generator")
	@NotNull
	@Column(name = "rut_id")
	private int idRutina;
	
	@NotNull
	@NotEmpty
	@Column(name = "rut_nombre")
	private String nombre;
	
	@Column(name = "rut_descripcion")
	private String descripcion;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "rut_id")
	private List<Ejercicio> ejercicios;
	
	public void addEjercicio(Ejercicio ejercicio) {
		if(ejercicios == null)
			ejercicios = new ArrayList<>();
		ejercicios.add(ejercicio);
	}
	
	public void removeEjercicio(Ejercicio ejercicio) {
		ejercicios.remove(ejercicio);
	}

	public int getIdRutina() {
		return idRutina;
	}

	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	
	
	
}
