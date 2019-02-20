package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import javax.persistence.Column;
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
}
