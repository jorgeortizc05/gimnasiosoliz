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
 * Fecha Creacion: 19/02/2019
 * Fecha Modificacion:
 * Nota: Entidad para datos de telefono
 */

@Entity
public class Complexion {

	@Id
	@SequenceGenerator(name="comp_generator", initialValue=1, allocationSize = 1,  sequenceName="comp_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "comp_generator")
	@NotNull
	@Column(name = "tel_id")
	private int idComplexion;
	
	private Double altura;
	
	private Double peso;
	
	//Si es alta, mediana o baja
	private String estatura;
	
	//Calcula automaticamente el indice corporal
	private Double indiceCorporal;
	
	//Detalle del sobrepeso si es muy delgado, normal, sobrepeso
	private String estadoPeso;

	//Getter and setters
	
	public int getIdComplexion() {
		return idComplexion;
	}

	public void setIdComplexion(int idComplexion) {
		this.idComplexion = idComplexion;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public Double getIndiceCorporal() {
		return indiceCorporal;
	}

	public void setIndiceCorporal(Double indiceCorporal) {
		this.indiceCorporal = indiceCorporal;
	}

	public String getEstadoPeso() {
		return estadoPeso;
	}

	public void setEstadoPeso(String estadoPeso) {
		this.estadoPeso = estadoPeso;
	}

	@Override
	public String toString() {
		return "Complexion [idComplexion=" + idComplexion + ", altura=" + altura + ", peso=" + peso + ", estatura="
				+ estatura + ", indiceCorporal=" + indiceCorporal + ", estadoPeso=" + estadoPeso + "]";
	}
	
	
}
