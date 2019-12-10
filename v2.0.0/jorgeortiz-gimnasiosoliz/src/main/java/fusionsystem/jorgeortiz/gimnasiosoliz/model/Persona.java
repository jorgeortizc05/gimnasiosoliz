package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_id")
	private Integer perId = 0;

	@Column(name="per_activo")
	private String perActivo;

	@Column(name="per_cedula")
	private String perCedula;

	@Column(name="per_direccion")
	private String perDireccion;

	@Column(name="per_email")
	private String perEmail;

	@Column(name="per_fecha_nac")
	private Timestamp perFechaNac;

	@Column(name="per_nombres")
	private String perNombres;

	@Column(name="per_pass")
	private String perPass;

	@Column(name="per_telefono")
	private String perTelefono;

	@Column(name="tper_id")
	private Integer tperId;

	public Persona() {
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerActivo() {
		return this.perActivo;
	}

	public void setPerActivo(String perActivo) {
		this.perActivo = perActivo;
	}

	public String getPerCedula() {
		return this.perCedula;
	}

	public void setPerCedula(String perCedula) {
		this.perCedula = perCedula;
	}

	public String getPerDireccion() {
		return this.perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Timestamp getPerFechaNac() {
		return this.perFechaNac;
	}

	public void setPerFechaNac(Timestamp perFechaNac) {
		this.perFechaNac = perFechaNac;
	}

	public String getPerNombres() {
		return this.perNombres;
	}

	public void setPerNombres(String perNombres) {
		this.perNombres = perNombres;
	}

	public String getPerPass() {
		return this.perPass;
	}

	public void setPerPass(String perPass) {
		this.perPass = perPass;
	}

	public String getPerTelefono() {
		return this.perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	public Integer getTperId() {
		return this.tperId;
	}

	public void setTperId(Integer tperId) {
		this.tperId = tperId;
	}

}