package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.ComplexionBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.PersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Complexion;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.Mensajes;

@ManagedBean
@ViewScoped
public class PersonaController {
	
	@Inject
	private PersonaBussiness perBuss;
	private Persona newPersona;
	private List<Persona> listPer;
	
	@Inject
	private ComplexionBussiness compBuss;
	private List<Complexion> listComplex;
	private Complexion newComplexion;
	
	
	//Variables
	private int vPerId;
	private boolean vEditing;
	private int vTipPerId;
	
	@PostConstruct
	public void init() {
		vEditing = false;
		newPersona = new Persona();
		newComplexion = new Complexion();
		loadListPer();
	}
	
	public String guardarPersona() {
		
		try {
			
			if(vEditing) {
				newPersona.setTperId(vTipPerId);
				perBuss.updatePersona(newPersona);
			}else {
				newPersona.setTperId(vTipPerId);
				perBuss.guardarPersona(newPersona);
				vEditing = false;
			}
			
			return "list-personas?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
		return null;
	}
	
	public String guardarComplexion() {
		
		try {
			newComplexion.setPerId(newPersona.getPerId());
			compBuss.guardarComplexion(newComplexion);
			listComplex = compBuss.getListPerCompl(newPersona.getPerId());
			newComplexion = new Complexion();
			return null;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
		return null;
	}
	
	public String buscarPerID()  {
		try {
			newPersona = perBuss.buscarPersonaId(vPerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
		return null;
		
	}
	
	////////////////////////////START UPDATE//////////////////////////////////////////////
	public String irUpdPersona(Persona persona) {
		return "nueva-persona?faces-redirect=true&id="+persona.getPerId();
	}
	public void cargarPersona() {
		if(vPerId == 0 )
			return;
		
		try {
			//loadListTipPers();
			newPersona = perBuss.buscarPersonaId(vPerId);
			vTipPerId = newPersona.getTperId();
			listComplex = compBuss.getListPerCompl(newPersona.getPerId());
			vEditing = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
	}
	
	///////////////////////////END UPDATE///////////////////////////////////////////////
	
	public String deletePersona(Persona per)  {
		try {
			perBuss.deletePersona(per.getPerId());
			loadListPer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
			Mensajes.addMessageInfo(per.getPerNombres() + " ya tiene registros");
		}
		
		return null;
	}
	
	public String deleteComplexion(Complexion comp){
		try {
			compBuss.deleteComplexion(comp.getTelId());
			listComplex = compBuss.getListPerCompl(newPersona.getPerId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageError("Problemas al eliminar");
		}
		
		
		
		return null;
	}
	
	public void loadListPer() {
		try {
			listPer = perBuss.getListPer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
	}
	
	//Validar cedula
	public void valida(String x){
	    int suma=0;
	    if(x.length()==9){
	      System.out.println("Ingrese su cedula de 10 digitos");
          Mensajes.addMessageError("Ingrese su cedula de 10 digitos");
	    }else{
	      int a[]=new int [x.length()/2];
	      int b[]=new int [(x.length()/2)];
	      int c=0;
	      int d=1;
	      for (int i = 0; i < x.length()/2; i++) {
	        a[i]=Integer.parseInt(String.valueOf(x.charAt(c)));
	        c=c+2;
	        if (i < (x.length()/2)-1) {
	          b[i]=Integer.parseInt(String.valueOf(x.charAt(d)));
	          d=d+2;
	        }
	      }
	    
	      for (int i = 0; i < a.length; i++) {
	        a[i]=a[i]*2;
	        if (a[i] >9){
	          a[i]=a[i]-9;
	        }
	        suma=suma+a[i]+b[i];
	      } 
	      int aux=suma/10;
	      int dec=(aux+1)*10;
	      if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length()-1)))) {
          	  Mensajes.addMessageInfo("Cedula Correcta");
	      }
	      else
	        if(suma%10==0 && x.charAt(x.length()-1)=='0'){
	          	Mensajes.addMessageInfo("Cedula Correcta");
	        }else{
	          	Mensajes.addMessageError("Cedula incorrecta");
	        }
	    }
	     
	  }

	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}

	public int getvPerId() {
		return vPerId;
	}

	public void setvPerId(int vPerId) {
		this.vPerId = vPerId;
	}

	public boolean isvEditing() {
		return vEditing;
	}
 
	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public List<Persona> getListPer() {
		return listPer;
	}

	public int getvTipPerId() {
		return vTipPerId;
	}

	public void setvTipPerId(int vTipPerId) {
		this.vTipPerId = vTipPerId;
	}

	public List<Complexion> getListComplex() {
		return listComplex;
	}

	public Complexion getNewComplexion() {
		return newComplexion;
	}

	public void setNewComplexion(Complexion newComplexion) {
		this.newComplexion = newComplexion;
	}
	
	
	

}
