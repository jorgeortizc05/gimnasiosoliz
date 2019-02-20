package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 20/02/2019
 * Nota: Mantenimiento para Facturas cabeceras.
 * 
 * MODIFICACIONES
 * Fecha Modificacion: 
 * 
 */
@Entity
public class Factura {
	
	@Id
	@SequenceGenerator(name="fact_generator", initialValue=1, allocationSize = 1,  sequenceName="fact_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "fact_generator")
	@NotNull
	@Column(name = "fact_id")
	private int idFactura;
	
	@Column(name = "fact_serie")
	private String serie;//Numero de factura
	
	@Column(name = "fact_fec_emision")
	private Date fechaEmision = new Date();
	
	@Column(name = "fact_lug_emision")
	private String lugarEmision = "PAUTE";
	
	@Column(name = "fact_subtotal")
	private Double subtotal;
	
	@Column(name = "fact_descuento")
	private Double descuento;
	
	@Column(name = "fact_iva")
	private Double iva;
	
	@Column(name = "fact_vtotal")
	private Double valorTotal;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fact_id")
	private List<DetalleFactura> detalleFacturas;

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getLugarEmision() {
		return lugarEmision;
	}

	public void setLugarEmision(String lugarEmision) {
		this.lugarEmision = lugarEmision;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}
	
	
	
}
