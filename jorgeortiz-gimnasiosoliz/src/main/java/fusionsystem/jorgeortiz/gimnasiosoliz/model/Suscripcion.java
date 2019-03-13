package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Suscripcion {

	@Id
	@SequenceGenerator(name="sus_generator", initialValue=1, allocationSize = 1000,  sequenceName="sus_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sus_generator")
	@NotNull
	@Column(name = "sus_id")
	private int idSuscripcion;
	
	@Column(name = "sus_fecha_desde")
	private Date fechaDesde;
	
	@Column(name = "sus_fecha_hasta")
	private Date fechaHasta;
	
	@Column(name = "sus_tipo")
	private String tipo = "Normal";
	
	@ManyToOne
	@JoinColumn(name = "per_id")
	private Persona persona;

	public int getIdSuscripcion() {
		return idSuscripcion;
	}

	public void setIdSuscripcion(int idSuscripcion) {
		this.idSuscripcion = idSuscripcion;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Suscripcion [idSuscripcion=" + idSuscripcion + ", fechaDesde=" + fechaDesde + ", fechaHasta="
				+ fechaHasta + ", tipo=" + tipo + ", persona=" + persona + "]";
	}
	
	
	
}
