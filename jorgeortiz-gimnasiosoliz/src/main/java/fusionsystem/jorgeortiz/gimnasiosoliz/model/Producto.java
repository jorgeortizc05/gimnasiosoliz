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
 * Fecha Creacion: 20/02/2019
 * Nota: Mantenimiento para Ejercicio.
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 
 * 
 */
@Entity
public class Producto {
	@Id
	@SequenceGenerator(name="prod_generator", initialValue=1, allocationSize = 1,  sequenceName="prod_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "prod_generator")
	@NotNull
	@Column(name = "prod_id")
	private int idProducto;
	
	@NotNull
	@NotEmpty
	@Column(name = "prod_nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Column(name = "prod_codigo")
	private String codigo;
	
	@Column(name = "prod_precio")
	private Double precio;
	
	@Column(name = "prod_descripcion")
	private String descripcion;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
