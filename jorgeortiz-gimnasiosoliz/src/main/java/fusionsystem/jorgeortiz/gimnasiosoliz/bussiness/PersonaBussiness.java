package fusionsystem.jorgeortiz.gimnasiosoliz.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.dao.PersonaDAO;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Complexion;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;

@Stateless
public class PersonaBussiness {

	@Inject
	private PersonaDAO perDAO;
	
	//Guarda Persona verificando si existe o no
	public void doGuardar(Persona persona) throws Exception {
		boolean vCedula = valida(persona.getCedula());
		Persona auxp = perDAO.readPersonaComplexion(persona.getIdPersona());
		Persona auxCedula = perDAO.getPersonaCedula(persona.getCedula());
		if(auxp != null || auxCedula != null) 
			throw new Exception("Persona ya existe");
		else {
			
				for(Complexion com: persona.getComplexiones()) {
					Double calculaPesoIdeal = (com.getPeso())/Math.pow((com.getAltura()*0.01),2);
					com.setIndiceCorporal(calculaPesoIdeal);
				}
				perDAO.insert(persona);
			
		}
	}
	
	//Validar cedula
	public boolean valida(String x){
	    int suma=0;
	    if(x.length()==9){
	      System.out.println("Ingrese su cedula de 10 digitos");
	      return false;
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
	    	 return true;
	      }
	      else
	        if(suma%10==0 && x.charAt(x.length()-1)=='0'){
	        	return true;
	        }else{
	        	return false;
	        }
	    }
	     
	  }
	
	//Actualiza Persona verificando si existe o no
	public void doActualizar(Persona persona) throws Exception {
		
		Persona auxp = perDAO.readPersonaComplexion(persona.getIdPersona());
		if(auxp == null) {
			throw new Exception("Persona no existe");
		}
		else { 
			for(Complexion com: persona.getComplexiones()) {
				Double calculaPesoIdeal = (com.getPeso())/Math.pow((com.getAltura()*0.01),2);
				System.out.println("Calculo Peso Ideal "+calculaPesoIdeal);
				com.setIndiceCorporal(calculaPesoIdeal);
			}
			perDAO.update(persona);
		}
		
	}
	
	//Elimina Persona verificando si existe o no
	public void doEliminar(int id) throws Exception {
		Persona auxp = perDAO.readPersonaComplexion(id);
		if(auxp != null) 
			perDAO.delete(id);
		else 
			throw new Exception("Persona no existe");	
	}
	
	//Carga un objeto Persona
	public Persona getPersona(int id) {
		
		return perDAO.readPersonaComplexion(id);
	}
	
	//Recupera una lista de Persona
	public List<Persona> getPersonas(){
		
		return perDAO.getPersonas();
	}
}
