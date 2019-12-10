package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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
	private Timestamp dfactFechaDesde;

	@Column(name="dfact_fecha_hasta")
	private Timestamp dfactFechaHasta;

	@Column(name="dfact_val_total")
	private double dfactValTotal;

	@Column(name="dfact_val_unitario")
	private double dfactValUnitario;

	@Column(name="fact_id")
	private Integer factId;

	@Column(name="prod_id")
	private Integer prodId;

	public Detallefactura() {
	}

	public Integer getDfactId() {
		return this.dfactId;
	}

	public void setDfactId(Integer dfactId) {
		this.dfactId = dfactId;
	}

	public Integer getDfactCantidad() {
		return this.dfactCantidad;
	}

	public void setDfactCantidad(Integer dfactCantidad) {
		this.dfactCantidad = dfactCantidad;
	}

	public Integer getDfactDiasRestantes() {
		return this.dfactDiasRestantes;
	}

	public void setDfactDiasRestantes(Integer dfactDiasRestantes) {
		this.dfactDiasRestantes = dfactDiasRestantes;
	}

	public Timestamp getDfactFechaDesde() {
		return this.dfactFechaDesde;
	}

	public void setDfactFechaDesde(Timestamp dfactFechaDesde) {
		this.dfactFechaDesde = dfactFechaDesde;
	}

	public Timestamp getDfactFechaHasta() {
		return this.dfactFechaHasta;
	}

	public void setDfactFechaHasta(Timestamp dfactFechaHasta) {
		this.dfactFechaHasta = dfactFechaHasta;
	}

	public double getDfactValTotal() {
		return this.dfactValTotal;
	}

	public void setDfactValTotal(double dfactValTotal) {
		this.dfactValTotal = dfactValTotal;
	}

	public double getDfactValUnitario() {
		return this.dfactValUnitario;
	}

	public void setDfactValUnitario(double dfactValUnitario) {
		this.dfactValUnitario = dfactValUnitario;
	}

	public Integer getFactId() {
		return this.factId;
	}

	public void setFactId(Integer factId) {
		this.factId = factId;
	}

	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

}