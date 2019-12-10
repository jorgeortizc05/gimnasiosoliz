package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fact_id")
	private Integer factId = 0;

	@Column(name="fact_descuento")
	private double factDescuento;

	@Column(name="fact_estado")
	private String factEstado;

	@Column(name="fact_fec_emision")
	private Timestamp factFecEmision;

	@Column(name="fact_iva")
	private double factIva;

	@Column(name="fact_lug_emision")
	private String factLugEmision;

	@Column(name="fact_serie")
	private String factSerie;

	@Column(name="fact_subtotal")
	private double factSubtotal;

	@Column(name="fact_tipo_comprobante")
	private String factTipoComprobante;

	@Column(name="fact_vtotal")
	private double factVtotal;

	@Column(name="fp_id")
	private Integer fpId;

	@Column(name="per_id")
	private Integer perId;

	public Factura() {
	}

	public Integer getFactId() {
		return this.factId;
	}

	public void setFactId(Integer factId) {
		this.factId = factId;
	}

	public double getFactDescuento() {
		return this.factDescuento;
	}

	public void setFactDescuento(double factDescuento) {
		this.factDescuento = factDescuento;
	}

	public String getFactEstado() {
		return this.factEstado;
	}

	public void setFactEstado(String factEstado) {
		this.factEstado = factEstado;
	}

	public Timestamp getFactFecEmision() {
		return this.factFecEmision;
	}

	public void setFactFecEmision(Timestamp factFecEmision) {
		this.factFecEmision = factFecEmision;
	}

	public double getFactIva() {
		return this.factIva;
	}

	public void setFactIva(double factIva) {
		this.factIva = factIva;
	}

	public String getFactLugEmision() {
		return this.factLugEmision;
	}

	public void setFactLugEmision(String factLugEmision) {
		this.factLugEmision = factLugEmision;
	}

	public String getFactSerie() {
		return this.factSerie;
	}

	public void setFactSerie(String factSerie) {
		this.factSerie = factSerie;
	}

	public double getFactSubtotal() {
		return this.factSubtotal;
	}

	public void setFactSubtotal(double factSubtotal) {
		this.factSubtotal = factSubtotal;
	}

	public String getFactTipoComprobante() {
		return this.factTipoComprobante;
	}

	public void setFactTipoComprobante(String factTipoComprobante) {
		this.factTipoComprobante = factTipoComprobante;
	}

	public double getFactVtotal() {
		return this.factVtotal;
	}

	public void setFactVtotal(double factVtotal) {
		this.factVtotal = factVtotal;
	}

	public Integer getFpId() {
		return this.fpId;
	}

	public void setFpId(Integer fpId) {
		this.fpId = fpId;
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

}