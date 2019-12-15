package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the reporte_ventas_view database table.
 * 
 */
@Entity
@Table(name="reporte_ventas_view")
@NamedQuery(name="ReporteVentasView.findAll", query="SELECT r FROM ReporteVentasView r")
public class ReporteVentasView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="fact_estado")
	private String factEstado;

	@Column(name="fact_fec_emision")
	private Date factFecEmision;
	
	@Id
	@Column(name="fact_id")
	private Integer factId;

	@Column(name="fact_vtotal")
	private Double factVtotal;

	@Column(name="per_nombres")
	private String perNombres;

	public ReporteVentasView() {
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

	public Integer getFactId() {
		return factId;
	}

	public void setFactId(Integer factId) {
		this.factId = factId;
	}

	public Double getFactVtotal() {
		return factVtotal;
	}

	public void setFactVtotal(Double factVtotal) {
		this.factVtotal = factVtotal;
	}

	public String getPerNombres() {
		return perNombres;
	}

	public void setPerNombres(String perNombres) {
		this.perNombres = perNombres;
	}

	

}