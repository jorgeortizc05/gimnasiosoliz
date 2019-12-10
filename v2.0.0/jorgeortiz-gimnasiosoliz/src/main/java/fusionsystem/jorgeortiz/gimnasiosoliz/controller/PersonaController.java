package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.PersonaBussiness;
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
	
	private TipoPersona newTipoPersona;
	
	//Variables
	private int vPerId;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		vEditing = false;
		newPersona = new Persona();
		newTipoPersona = new TipoPersona();
		loadListPer();
	}
	
	public String guardarPersona() {
		
		try {
			
			if(vEditing) {
				perBuss.updatePersona(newPersona);
			}else {
				newPersona.setTperId(newTipoPersona.getTperId());
				System.out.println(newTipoPersona);
				System.out.println(newPersona);
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
		return "nuevo-Persona?faces-redirect=true&id="+persona.getPerId();
	}
	public void cargarPersona() {
		if(vPerId == 0 )
			return;
		
		try {
			newPersona = perBuss.buscarPersonaId(vPerId);
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

	public TipoPersona getNewTipoPersona() {
		return newTipoPersona;
	}

	public void setNewTipoPersona(TipoPersona newTipoPersona) {
		this.newTipoPersona = newTipoPersona;
	}
	
	


}
