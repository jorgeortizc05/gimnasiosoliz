package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the detallefactura database table.
 * 
 */
@Entity
@NamedQuery(name="Detallefactura.findAll", query="SELECT d FROM Detallefactura d")
public class Detallefactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dfact_id")
	private Integer dfactId = 0;

	@Column(name="dfact_cantidad")
	private Integer dfactCantidad;

	@Column(name="dfact_dias_restantes")
	private Integer dfactDiasRestantes;

	@Column(name="dfact_fecha_desde")
	private Date dfactFechaDesde;

	@Column(name="dfact_fecha_hasta")
	private Date dfactFechaHasta;

	@Column(name="dfact_val_total")
	private Double dfactValTotal;

	@Column(name="dfact_val_unitario")
	private Double dfactValUnitario;

	@Column(name="fact_id")
	private Integer factId;

	@Column(name="prod_id")
	private Integer prodId;

	public Detallefactura() {
	}

	public Integer getDfactId() {
		return dfactId;
	}

	public void setDfactId(Integer dfactId) {
		this.dfactId = dfactId;
	}

	public Integer getDfactCantidad() {
		return dfactCantidad;
	}

	public void setDfactCantidad(Integer dfactCantidad) {
		this.dfactCantidad = dfactCantidad;
	}

	public Integer getDfactDiasRestantes() {
		return dfactDiasRestantes;
	}

	public void setDfactDiasRestantes(Integer dfactDiasRestantes) {
		this.dfactDiasRestantes = dfactDiasRestantes;
	}

	public Date getDfactFechaDesde() {
		return dfactFechaDesde;
	}

	public void setDfactFechaDesde(Date dfactFechaDesde) {
		this.dfactFechaDesde = dfactFechaDesde;
	}

	public Date getDfactFechaHasta() {
		return dfactFechaHasta;
	}

	public void setDfactFechaHasta(Date dfactFechaHasta) {
		this.dfactFechaHasta = dfactFechaHasta;
	}

	public Double getDfactValTotal() {
		return dfactValTotal;
	}

	public void setDfactValTotal(Double dfactValTotal) {
		this.dfactValTotal = dfactValTotal;
	}

	public Double getDfactValUnitario() {
		return dfactValUnitario;
	}

	public void setDfactValUnitario(Double dfactValUnitario) {
		this.dfactValUnitario = dfactValUnitario;
	}

	public Integer getFactId() {
		return factId;
	}

	public void setFactId(Integer factId) {
		this.factId = factId;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	

}