package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 20/02/2019
 * Fecha Modificacion:
 * Nota: Mantenimiento para Tipo de Persona;.
 */
@Entity
public class TipoPersona {

	@Id
	@SequenceGenerator(name="tper_generator", initialValue=1, allocationSize = 1,  sequenceName="tper_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tper_generator")
	@NotNull
	@Column(name = "tper_id")
	private int idTipoPersona;
	
	@NotNull
	@NotEmpty
	@Column(name = "tper_nombre")
	private String nombre;
	
	@Column(name = "tper_descripcion")
	private String descripcion;

	public int getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(int idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
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

	@Override
	public String toString() {
		return "TipoPersona [idTipoPersona=" + idTipoPersona + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ "]";
	}
	
	
}
