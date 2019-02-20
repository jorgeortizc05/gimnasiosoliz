package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 19/02/2019
 * Fecha Modificacion:
 * Nota: Entidad para datos de telefono
 */
@Entity
public class Telefono {
	@Id
	@SequenceGenerator(name="tel_generator", initialValue=1, allocationSize = 1,  sequenceName="tel_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tel_generator")
	@NotNull
	@Column(name = "tel_id")
	private int idTelefono;
	
	@Column(name = "tel_tipo")
	private int tipo;
	
	@Column(name = "tel_numero")
	private String numero;

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
