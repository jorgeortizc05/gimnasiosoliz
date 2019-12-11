package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the tipopersona database table.
 * 
 */
@Entity
@NamedQuery(name="Tipopersona.findAll", query="SELECT t FROM TipoPersona t")
public class TipoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tper_id")
	@NotNull
	private Integer tperId = 0;

	@Column(name="tper_descripcion")
	private String tperDescripcion;

	@Column(name="tper_nombre")
	@NotNull(message = "Tiene que ingresar un nombre")
	@Size(min = 1, max = 20)
	private String tperNombre;

	public TipoPersona() {
	}

	public Integer getTperId() {
		return this.tperId;
	}

	public void setTperId(Integer tperId) {
		this.tperId = tperId;
	}

	public String getTperDescripcion() {
		return this.tperDescripcion;
	}

	public void setTperDescripcion(String tperDescripcion) {
		this.tperDescripcion = tperDescripcion;
	}

	public String getTperNombre() {
		return this.tperNombre;
	}

	public void setTperNombre(String tperNombre) {
		this.tperNombre = tperNombre;
	}

	@Override
	public String toString() {
		return "TipoPersona [tperId=" + tperId + ", tperDescripcion=" + tperDescripcion + ", tperNombre=" + tperNombre
				+ "]";
	}
	
	

}