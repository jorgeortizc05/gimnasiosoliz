package fusionsystem.jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametrofactura database table.
 * 
 */
@Entity
@NamedQuery(name="Parametrofactura.findAll", query="SELECT p FROM Parametrofactura p")
public class Parametrofactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pf_id")
	private Integer pfId = 0;

	@Column(name="pf_dnum_comprobante")
	private String pfDnumComprobante;

	@Column(name="pf_s_punto_emision")
	private String pfSPuntoEmision;

	@Column(name="pf_serie_establecimiento")
	private String pfSerieEstablecimiento;

	public Parametrofactura() {
	}

	public Integer getPfId() {
		return pfId;
	}

	public void setPfId(Integer pfId) {
		this.pfId = pfId;
	}

	public String getPfDnumComprobante() {
		return pfDnumComprobante;
	}

	public void setPfDnumComprobante(String pfDnumComprobante) {
		this.pfDnumComprobante = pfDnumComprobante;
	}

	public String getPfSPuntoEmision() {
		return pfSPuntoEmision;
	}

	public void setPfSPuntoEmision(String pfSPuntoEmision) {
		this.pfSPuntoEmision = pfSPuntoEmision;
	}

	public String getPfSerieEstablecimiento() {
		return pfSerieEstablecimiento;
	}

	public void setPfSerieEstablecimiento(String pfSerieEstablecimiento) {
		this.pfSerieEstablecimiento = pfSerieEstablecimiento;
	}

	

}