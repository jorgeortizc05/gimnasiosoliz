package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the suscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Suscripcion.findAll", query="SELECT s FROM Suscripcion s")
public class Suscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sus_id")
	private Integer susId = 0;

	@Column(name="factura_fact_id")
	private Integer facturaFactId;

	@Column(name="per_id")
	private Integer perId;

	@Column(name="sus_descuento")
	private Double susDescuento;

	@Column(name="sus_fecha_desde")
	private Date susFechaDesde;

	@Column(name="sus_fecha_hasta")
	private Date susFechaHasta;

	@Column(name="sus_precio_neto")
	private Double susPrecioNeto;

	@Column(name="sus_tipo")
	private String susTipo;

	@Column(name="sus_total")
	private Double susTotal;

	public Suscripcion() {
	}

	public Integer getSusId() {
		return susId;
	}

	public void setSusId(Integer susId) {
		this.susId = susId;
	}

	public Integer getFacturaFactId() {
		return facturaFactId;
	}

	public void setFacturaFactId(Integer facturaFactId) {
		this.facturaFactId = facturaFactId;
	}

	public Integer getPerId() {
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public Double getSusDescuento() {
		return susDescuento;
	}

	public void setSusDescuento(Double susDescuento) {
		this.susDescuento = susDescuento;
	}

	public Date getSusFechaDesde() {
		return susFechaDesde;
	}

	public void setSusFechaDesde(Date susFechaDesde) {
		this.susFechaDesde = susFechaDesde;
	}

	public Date getSusFechaHasta() {
		return susFechaHasta;
	}

	public void setSusFechaHasta(Date susFechaHasta) {
		this.susFechaHasta = susFechaHasta;
	}

	public Double getSusPrecioNeto() {
		return susPrecioNeto;
	}

	public void setSusPrecioNeto(Double susPrecioNeto) {
		this.susPrecioNeto = susPrecioNeto;
	}

	public String getSusTipo() {
		return susTipo;
	}

	public void setSusTipo(String susTipo) {
		this.susTipo = susTipo;
	}

	public Double getSusTotal() {
		return susTotal;
	}

	public void setSusTotal(Double susTotal) {
		this.susTotal = susTotal;
	}

	
}