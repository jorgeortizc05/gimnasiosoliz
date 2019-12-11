package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.FormaPagoBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.FormaPago;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.Mensajes;

@ManagedBean
@ViewScoped
public class FormaPagoController {

	//Tipo Persona
		@Inject
		private FormaPagoBussiness fpBuss;
		
		private FormaPago newFormaPago;
		private List<FormaPago> listFormPag;
		
		//Variables
		private int vFPId;
		private boolean vEditing;
		
		@PostConstruct
		public void init() {
			vEditing = false;
			newFormaPago = new FormaPago();
			loadListFormPag();
		}
		
		public String guardarFormaPago() {
			
			try {
				
				if(vEditing) {
					fpBuss.updateFormaPago(newFormaPago);
				}else {
					fpBuss.guardarFormaPago(newFormaPago);
					vEditing = false;
				}
				
				return "list-forma-pagos?faces-redirect=true";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
			
			return null;
		}
		
		public String buscarFormaPagoID()  {
			try {
				newFormaPago = fpBuss.buscarFormaPagoId(vFPId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
			
			return null;
			
		}
		
		////////////////////////////START UPDATE//////////////////////////////////////////////
		public String irUpdFormaPago(FormaPago FormaPago) {
			return "nueva-forma-pago?faces-redirect=true&id="+FormaPago.getFpId();
		}
		public void cargarFormaPago() {
			if(vFPId == 0 )
				return;
			
			try {
				newFormaPago = fpBuss.buscarFormaPagoId(vFPId);
				vEditing = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
		}
		
		///////////////////////////END UPDATE///////////////////////////////////////////////
		
		public String deleteFormaPago(FormaPago prod)  {
			try {
				fpBuss.deleteFormaPago(prod.getFpId());
				loadListFormPag();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
				Mensajes.addMessageInfo(prod.getFpNombre() + " ya tiene registros");
			}
			
			return null;
		}
		
		public void loadListFormPag() {
			try {
				listFormPag = fpBuss.getListFormPag();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensajes.addMessageInfo(e.getMessage());
			}
			
		}

		public FormaPago getNewFormaPago() {
			return newFormaPago;
		}

		public void setNewFormaPago(FormaPago newFormaPago) {
			this.newFormaPago = newFormaPago;
		}

		

		public int getvFPId() {
			return vFPId;
		}

		public void setvFPId(int vFPId) {
			this.vFPId = vFPId;
		}

		public boolean isvEditing() {
			return vEditing;
		}

		public void setvEditing(boolean vEditing) {
			this.vEditing = vEditing;
		}

		public List<FormaPago> getListFormPag() {
			return listFormPag;
		}
		
		

		
}
