package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Digits;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prod_id")
	private Integer prodId = 0;

	@Column(name="prod_codigo")
	private String prodCodigo;

	@Column(name="prod_descripcion")
	private String prodDescripcion;

	@Column(name="prod_nombre")
	private String prodNombre;

	@Column(name="prod_precio")
	@Digits(fraction = 2, integer = 6)
	private double prodPrecio;

	public Producto() {
	}

	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdCodigo() {
		return this.prodCodigo;
	}

	public void setProdCodigo(String prodCodigo) {
		this.prodCodigo = prodCodigo;
	}

	public String getProdDescripcion() {
		return this.prodDescripcion;
	}

	public void setProdDescripcion(String prodDescripcion) {
		this.prodDescripcion = prodDescripcion;
	}

	public String getProdNombre() {
		return this.prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}

	public double getProdPrecio() {
		return this.prodPrecio;
	}

	public void setProdPrecio(double prodPrecio) {
		this.prodPrecio = prodPrecio;
	}

}