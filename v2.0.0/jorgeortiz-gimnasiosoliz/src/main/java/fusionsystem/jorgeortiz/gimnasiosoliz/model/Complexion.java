package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the complexion database table.
 * 
 */
@Entity
@NamedQuery(name="Complexion.findAll", query="SELECT c FROM Complexion c")
public class Complexion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tel_id")
	private Integer telId = 0;

	private double altura;

	private String estadopeso;

	private String estatura;

	private double indicecorporal;

	@Column(name="per_id")
	private Integer perId;

	private double peso;

	public Complexion() {
	}

	public Integer getTelId() {
		return this.telId;
	}

	public void setTelId(Integer telId) {
		this.telId = telId;
	}

	public double getAltura() {
		return this.altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getEstadopeso() {
		return this.estadopeso;
	}

	public void setEstadopeso(String estadopeso) {
		this.estadopeso = estadopeso;
	}

	public String getEstatura() {
		return this.estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public double getIndicecorporal() {
		return this.indicecorporal;
	}

	public void setIndicecorporal(double indicecorporal) {
		this.indicecorporal = indicecorporal;
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}