package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
public class ParametroFactura {

	@Id
	@Column(name = "pf_id")
	@SequenceGenerator(name="pf_generator", initialValue=100, allocationSize = 1,  sequenceName="pf_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pf_generator")
	private int idParametroFactura;
	
	@Column(name = "pf_serie_establecimiento")
	@Size(min=3, max=3, message="Ingrese 3 digitos")
	private String serieEstablecimiento;//3 digitos
	
	@Column(name = "pf_s_punto_emision")
	@Size(min=3, max=3, message="Ingrese 3 digitos")
	private String seriePuntoEmision;
	
	@Column(name = "pf_dnum_comprobante")
	private String desdeNumComprobante;

	public int getIdParametroFactura() {
		return idParametroFactura;
	}

	public void setIdParametroFactura(int idParametroFactura) {
		this.idParametroFactura = idParametroFactura;
	}

	public String getSerieEstablecimiento() {
		return serieEstablecimiento;
	}

	public void setSerieEstablecimiento(String serieEstablecimiento) {
		this.serieEstablecimiento = serieEstablecimiento;
	}

	public String getSeriePuntoEmision() {
		return seriePuntoEmision;
	}

	public void setSeriePuntoEmision(String seriePuntoEmision) {
		this.seriePuntoEmision = seriePuntoEmision;
	}

	public String getDesdeNumComprobante() {
		return desdeNumComprobante;
	}

	public void setDesdeNumComprobante(String desdeNumComprobante) {
		this.desdeNumComprobante = desdeNumComprobante;
	}
	
}
