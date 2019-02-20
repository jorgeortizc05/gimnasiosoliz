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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 19/02/2019
 * Fecha Modificacion:
 * Nota: Mantenimiento para persona.
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
	
	@Column(name = "per_fecha_nac")
	private String direccion;
	
	//Parametros que ingresara el usuario en caso de movil o administrador.
	@NotNull
	@NotEmpty
	@Email
	@Column(name= "per_email")
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=30)
	@Column(name= "per_pass")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="per_id")
	private List<Telefono> telefonos;
	//Metodo para add telefono
	//Telefono telefono es el parametro de la clase telefono
	public void addTelefono(Telefono telefono) {
		if(telefonos == null)
			telefonos = new ArrayList<>();
		telefonos.add(telefono);
	}
	//Metodo para remove Telefono
	//Parametro telefono para ver que telefono se va a eliminar
	public void removeTelefono(Telefono telefono) {
		telefonos.remove(telefono);
	}
	
}
