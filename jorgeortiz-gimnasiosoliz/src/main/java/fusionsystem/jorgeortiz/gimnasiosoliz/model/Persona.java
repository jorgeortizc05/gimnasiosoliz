package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 19/02/2019
 * Nota: Mantenimiento para persona.
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 20/02/2019
 * Se agrego onetomany a tipoPersona, ejercicio
 */
@Entity
public class Persona {
	@Id
	@SequenceGenerator(name="per_generator", initialValue=1, allocationSize = 1,  sequenceName="per_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "per_generator")
	@NotNull
	@Column(name = "per_id")
	private int idPersona;
	
	@NotNull
	@NotEmpty
	@Size(min = 9, max = 12)
	@Column(name = "per_cedula")
	private String cedula;
	
	@NotNull
	@NotEmpty
	@Column(name = "per_nombres")
	private String nombres;
	
	@Column(name = "per_fecha_nac")
	private Date fechaNacimiento;
	
	@Column(name = "per_direccion")
	private String direccion;
	
	@Column(name = "per_telefono")
	private String telefono;
	
	//Parametros que ingresara el usuario en caso de movil o administrador.
	@Email
	@Column(name= "per_email")
	private String email;
	
	@Column(name= "per_pass")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="per_id")
	private List<Complexion> complexiones;
	//Metodo para add Complexion
	//Complexion complexion es el parametro de la clase Complexion
	public void addComplexion(Complexion complexion) {
		if(complexiones == null)
			complexiones = new ArrayList<>();
		complexiones.add(complexion);
	}
	
	//Metodo para remove complexion
	//Parametro complexion para ver que complexion se va a eliminar
	public void removeComplexion(Complexion comp) {
		complexiones.remove(comp);
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="per_id")
	private List<Ejercicio> ejercicios;
	
	public void addEjercicio(Ejercicio ejercicio) {
		if(ejercicios == null)
			ejercicios = new ArrayList<>();
		ejercicios.add(ejercicio);
	}
	
	public void removeEjercicio(Ejercicio ejercicio) {
		ejercicios.remove(ejercicio);
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tper_id")
	private TipoPersona tipoPersona;
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Complexion> getComplexiones() {
		return complexiones;
	}
	public void setComplexiones(List<Complexion> complexiones) {
		this.complexiones = complexiones;
	}
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
