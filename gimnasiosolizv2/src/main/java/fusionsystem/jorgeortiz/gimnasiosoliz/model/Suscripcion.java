package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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
	private double susDescuento;

	@Column(name="sus_fecha_desde")
	private Timestamp susFechaDesde;

	@Column(name="sus_fecha_hasta")
	private Timestamp susFechaHasta;

	@Column(name="sus_precio_neto")
	private double susPrecioNeto;

	@Column(name="sus_tipo")
	private String susTipo;

	@Column(name="sus_total")
	private double susTotal;

	public Suscripcion() {
	}

	public Integer getSusId() {
		return this.susId;
	}

	public void setSusId(Integer susId) {
		this.susId = susId;
	}

	public Integer getFacturaFactId() {
		return this.facturaFactId;
	}

	public void setFacturaFactId(Integer facturaFactId) {
		this.facturaFactId = facturaFactId;
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public double getSusDescuento() {
		return this.susDescuento;
	}

	public void setSusDescuento(double susDescuento) {
		this.susDescuento = susDescuento;
	}

	public Timestamp getSusFechaDesde() {
		return this.susFechaDesde;
	}

	public void setSusFechaDesde(Timestamp susFechaDesde) {
		this.susFechaDesde = susFechaDesde;
	}

	public Timestamp getSusFechaHasta() {
		return this.susFechaHasta;
	}

	public void setSusFechaHasta(Timestamp susFechaHasta) {
		this.susFechaHasta = susFechaHasta;
	}

	public double getSusPrecioNeto() {
		return this.susPrecioNeto;
	}

	public void setSusPrecioNeto(double susPrecioNeto) {
		this.susPrecioNeto = susPrecioNeto;
	}

	public String getSusTipo() {
		return this.susTipo;
	}

	public void setSusTipo(String susTipo) {
		this.susTipo = susTipo;
	}

	public double getSusTotal() {
		return this.susTotal;
	}

	public void setSusTotal(double susTotal) {
		this.susTotal = susTotal;
	}

}