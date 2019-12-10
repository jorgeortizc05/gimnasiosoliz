package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formapago database table.
 * 
 */
@Entity
@NamedQuery(name="FormaPago.findAll", query="SELECT f FROM FormaPago f")
public class FormaPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fp_id")
	private Integer fpId  = 0;

	@Column(name="fp_descipcion")
	private String fpDescipcion;

	@Column(name="fp_nombre")
	private String fpNombre;

	public FormaPago() {
	}

	public Integer getFpId() {
		return this.fpId;
	}

	public void setFpId(Integer fpId) {
		this.fpId = fpId;
	}

	public String getFpDescipcion() {
		return this.fpDescipcion;
	}

	public void setFpDescipcion(String fpDescipcion) {
		this.fpDescipcion = fpDescipcion;
	}

	public String getFpNombre() {
		return this.fpNombre;
	}

	public void setFpNombre(String fpNombre) {
		this.fpNombre = fpNombre;
	}

}