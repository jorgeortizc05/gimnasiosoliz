package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import java.util.Date;


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
	private String perActivo = "A";

	@Column(name="per_cedula")
	@Size(min = 5, max = 12)
	private String perCedula;

	@Column(name="per_direccion")
	private String perDireccion;

	@Column(name="per_email")
	@Email
	private String perEmail;

	@Column(name="per_fecha_nac")
	@Past
	private Date perFechaNac;

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
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerActivo() {
		return perActivo;
	}

	public void setPerActivo(String perActivo) {
		this.perActivo = perActivo;
	}

	public String getPerCedula() {
		return perCedula;
	}

	public void setPerCedula(String perCedula) {
		this.perCedula = perCedula;
	}

	public String getPerDireccion() {
		return perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Date getPerFechaNac() {
		return perFechaNac;
	}

	public void setPerFechaNac(Date perFechaNac) {
		this.perFechaNac = perFechaNac;
	}

	public String getPerNombres() {
		return perNombres;
	}

	public void setPerNombres(String perNombres) {
		this.perNombres = perNombres;
	}

	public String getPerPass() {
		return perPass;
	}

	public void setPerPass(String perPass) {
		this.perPass = perPass;
	}

	public String getPerTelefono() {
		return perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	public Integer getTperId() {
		return tperId;
	}

	public void setTperId(Integer tperId) {
		this.tperId = tperId;
	}

}