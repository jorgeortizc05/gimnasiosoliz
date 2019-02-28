package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "fact_tipo_comprobante")
	private String tipoComprobante;//Si es factura, boleta, etc
	
	@Column(name = "fact_estado")
	private String estado = "A"; //Indica si esta activo o no la factura
	
	@Column(name = "fact_fec_emision")
	private Date fechaEmision = new Date();
	
	@Column(name = "fact_lug_emision")
	private String lugarEmision = "PAUTE";
	
	@Column(name = "fact_subtotal")
	private Double subtotal;
	
	@Column(name = "fact_descuento")
	private Double descuento;
	
	@Column(name = "fact_iva")
	private Double iva = 12.0;
	
	@Column(name = "fact_vtotal")
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "fp_id")
	private FormaPago formaPago;
	
	@ManyToOne
	@JoinColumn(name = "per_id")
	private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fact_id")
	private List<DetalleFactura> detalleFacturas;
	
	public void addDetalleFactura(DetalleFactura detalleFactura) {
		if(detalleFacturas ==null)
			detalleFacturas = new ArrayList<>();
		detalleFacturas.add(detalleFactura);
	}
	
	public void removeDetalleFactura(DetalleFactura detalleFactura) {
		detalleFacturas.remove(detalleFactura);
	}

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
