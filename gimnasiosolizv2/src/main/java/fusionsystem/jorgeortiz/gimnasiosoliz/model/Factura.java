package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


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
	private Integer factId;

	@Column(name="fact_descuento")
	private Double factDescuento;

	@Column(name="fact_estado")
	private String factEstado;

	@Column(name="fact_fec_emision")
	private Date factFecEmision;

	@Column(name="fact_iva")
	private double factIva;

	@Column(name="fact_lug_emision")
	private String factLugEmision;

	@Column(name="fact_serie")
	private String factSerie;

	@Column(name="fact_subtotal")
	private Double factSubtotal;

	@Column(name="fact_tipo_comprobante")
	private String factTipoComprobante;

	@Column(name="fact_vtotal")
	private Double factVtotal;

	@Column(name="fp_id")
	private Integer fpId;

	@Column(name="per_id")
	private Integer perId;

	public Factura() {
	}

	public Integer getFactId() {
		return factId;
	}

	public void setFactId(Integer factId) {
		this.factId = factId;
	}

	public Double getFactDescuento() {
		return factDescuento;
	}

	public void setFactDescuento(Double factDescuento) {
		this.factDescuento = factDescuento;
	}

	public String getFactEstado() {
		return factEstado;
	}

	public void setFactEstado(String factEstado) {
		this.factEstado = factEstado;
	}

	public Date getFactFecEmision() {
		return factFecEmision;
	}

	public void setFactFecEmision(Date factFecEmision) {
		this.factFecEmision = factFecEmision;
	}

	public double getFactIva() {
		return factIva;
	}

	public void setFactIva(double factIva) {
		this.factIva = factIva;
	}

	public String getFactLugEmision() {
		return factLugEmision;
	}

	public void setFactLugEmision(String factLugEmision) {
		this.factLugEmision = factLugEmision;
	}

	public String getFactSerie() {
		return factSerie;
	}

	public void setFactSerie(String factSerie) {
		this.factSerie = factSerie;
	}

	public Double getFactSubtotal() {
		return factSubtotal;
	}

	public void setFactSubtotal(Double factSubtotal) {
		this.factSubtotal = factSubtotal;
	}

	public String getFactTipoComprobante() {
		return factTipoComprobante;
	}

	public void setFactTipoComprobante(String factTipoComprobante) {
		this.factTipoComprobante = factTipoComprobante;
	}

	public Double getFactVtotal() {
		return factVtotal;
	}

	public void setFactVtotal(Double factVtotal) {
		this.factVtotal = factVtotal;
	}

	public Integer getFpId() {
		return fpId;
	}

	public void setFpId(Integer fpId) {
		this.fpId = fpId;
	}

	public Integer getPerId() {
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	

}