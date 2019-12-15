package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.fachada.FacturacionBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Factura;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.ReporteVentasView;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.Mensajes;

@ManagedBean
@ViewScoped
public class FacturacionController {

	//Tipo Persona
		@Inject
		private FacturacionBussiness factBuss;
		
		private Factura newFactura;
		private List<Factura> listFact;
		private List<ReporteVentasView> listFact1;
		
		//Variables
		private int vFactId;
		private boolean vEditing;
		private int vPerId;
		private int vFPId;
		private int vProdId;
		
		@PostConstruct
		public void init() {
			vEditing = false;
			newFactura = new Factura();
			//loadListFact();
			loadListFact1();
		}
		
		public String guardarFactura() {
			
			try {
				
				if(vEditing) {
					factBuss.updateFactura(newFactura);
				}else {
					factBuss.guardarFactura(newFactura);
					vEditing = false;
				}
				
				return "list-facturas?faces-redirect=true";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
			
			return null;
		}
		
		public String buscarFactId()  {
			try {
				newFactura = factBuss.buscarFactId(vFactId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
			
			return null;
			
		}
		
		////////////////////////////START UPDATE//////////////////////////////////////////////
		public String irUpdFact(Factura Factura) {
			return "nueva-venta?faces-redirect=true&id="+Factura.getFactId();
		}
		public void cargarFactura() {
			if(vFactId == 0 )
				return;
			
			try {
				newFactura = factBuss.buscarFactId(vFactId);
				vEditing = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
		}
		
		///////////////////////////END UPDATE///////////////////////////////////////////////
		
		public String deleteTipPers(Factura fact)  {
			try {
				factBuss.deleteFactura(fact.getFactId());
				loadListFact();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
				Mensajes.addMessageInfo("Factura ya tiene registros");
			}
			
			return null;
		}
		
		public void loadListFact() {
			try {
				listFact = factBuss.getListFact();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
			
		}
		
		public void loadListFact1() {
			try {
				listFact1 = factBuss.getListFact1();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
			
		}

		public Factura getNewFactura() {
			return newFactura;
		}

		public void setNewFactura(Factura newFactura) {
			this.newFactura = newFactura;
		}

		public int getvFactId() {
			return vFactId;
		}

		public void setvFactId(int vFactId) {
			this.vFactId = vFactId;
		}

		public boolean isvEditing() {
			return vEditing;
		}

		public void setvEditing(boolean vEditing) {
			this.vEditing = vEditing;
		}

		public List<Factura> getListFact() {
			return listFact;
		}

		public List<ReporteVentasView> getListFact1() {
			return listFact1;
		}

		public int getvPerId() {
			return vPerId;
		}

		public void setvPerId(int vPerId) {
			this.vPerId = vPerId;
		}

		public int getvFPId() {
			return vFPId;
		}

		public void setvFPId(int vFPId) {
			this.vFPId = vFPId;
		}

		public int getvProdId() {
			return vProdId;
		}

		public void setvProdId(int vProdId) {
			this.vProdId = vProdId;
		}
		
}
