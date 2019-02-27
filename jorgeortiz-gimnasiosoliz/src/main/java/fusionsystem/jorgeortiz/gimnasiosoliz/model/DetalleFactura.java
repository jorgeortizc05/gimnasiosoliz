package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 20/02/2019
 * Nota: Mantenimiento para detalles de facturas.
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 
 * 
 */
@Entity
public class DetalleFactura {
	
	@Id
	@SequenceGenerator(name="dfact_generator", initialValue=1, allocationSize = 1,  sequenceName="dfact_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "dfact_generator")
	@NotNull
	@Column(name = "dfact_id")
	private int idDetalleFactura;
	
	@Column(name = "dfact_val_unitario")
	private Double valorUnitario;
	
	@Column(name = "dfact_cantidad")
	private int cantidad;
	
	@Column(name = "dfact_val_total")
	private Double valorTotal;
	
	@Column(name = "dfact_fecha_desde")
	private Date fechaDesde;
	
	@Column(name = "dfact_fecha_hasta")
	private Date fechaHasta;
	
	@Column(name = "dfact_estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Producto producto;

	public int getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(int idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
