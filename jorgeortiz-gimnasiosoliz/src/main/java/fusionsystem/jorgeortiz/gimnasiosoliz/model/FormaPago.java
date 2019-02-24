package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class FormaPago {
	
	@Id
	@SequenceGenerator(name="fp_generator", initialValue=1, allocationSize = 1,  sequenceName="fp_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "fp_generator")
	@NotNull
	@Column(name = "fp_id")
	private int idFormaPago;
	
	@NotNull
	@NotEmpty
	@Column(name= "fp_nombre")
	private String nombre;
	
	@Column(name = "fp_descipcion")
	private String descripcion;

	public int getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
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
	
}
