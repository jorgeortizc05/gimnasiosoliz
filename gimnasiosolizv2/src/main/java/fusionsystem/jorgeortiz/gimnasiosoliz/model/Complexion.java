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

	private Double altura;

	private String estadopeso;

	private String estatura;

	private Double indicecorporal;

	@Column(name="per_id")
	private Integer perId;

	private Double peso;

	public Complexion() {
	}

	

	public Integer getTelId() {
		return telId;
	}



	public void setTelId(Integer telId) {
		this.telId = telId;
	}



	public Double getAltura() {
		return altura;
	}



	public void setAltura(Double altura) {
		this.altura = altura;
	}



	public String getEstadopeso() {
		return estadopeso;
	}



	public void setEstadopeso(String estadopeso) {
		this.estadopeso = estadopeso;
	}



	public String getEstatura() {
		return estatura;
	}



	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}



	public Double getIndicecorporal() {
		return indicecorporal;
	}



	public void setIndicecorporal(Double indicecorporal) {
		this.indicecorporal = indicecorporal;
	}



	public Integer getPerId() {
		return perId;
	}



	public void setPerId(Integer perId) {
		this.perId = perId;
	}



	public Double getPeso() {
		return peso;
	}



	public void setPeso(Double peso) {
		this.peso = peso;
	}



	@Override
	public String toString() {
		return "Complexion [telId=" + telId + ", altura=" + altura + ", estadopeso=" + estadopeso + ", estatura="
				+ estatura + ", indicecorporal=" + indicecorporal + ", perId=" + perId + ", peso=" + peso + "]";
	}
	
	

}