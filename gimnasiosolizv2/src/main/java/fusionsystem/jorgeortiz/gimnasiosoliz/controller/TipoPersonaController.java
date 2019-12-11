package fusionsystem.jorgeortiz.gimnasiosoliz.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fusionsystem.jorgeortiz.gimnasiosoliz.bussiness.TipoPersonaBussiness;
import fusionsystem.jorgeortiz.gimnasiosoliz.model.TipoPersona;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.Mensajes;

@ManagedBean
@ViewScoped
public class TipoPersonaController {
	
	
	//Tipo Persona
	@Inject
	private TipoPersonaBussiness tipPersBuss;
	
	private TipoPersona newTipoPersona;
	private List<TipoPersona> listTipPers;
	
	//Variables
	private int vTipPersID;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		vEditing = false;
		newTipoPersona = new TipoPersona();
		loadListTipPers();
	}
	
	public String guardarTipPers() {
		
		try {
			
			if(vEditing) {
				tipPersBuss.updateTipPers(newTipoPersona);
			}else {
				tipPersBuss.guardarTipPers(newTipoPersona);
				vEditing = false;
			}
			
			return "list-tipo-personas?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
		return null;
	}
	
	public String buscarTipPersID()  {
		try {
			newTipoPersona = tipPersBuss.buscarTipPersID(vTipPersID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
		return null;
		
	}
	
	////////////////////////////START UPDATE//////////////////////////////////////////////
	public String irUpdTipPers(TipoPersona tipoPersona) {
		return "nuevo-tipo-persona?faces-redirect=true&id="+tipoPersona.getTperId();
	}
	public void cargarTipoPersona() {
		if(vTipPersID == 0 )
			return;
		
		try {
			newTipoPersona = tipPersBuss.buscarTipPersID(vTipPersID);
			vEditing = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
	}
	
	///////////////////////////END UPDATE///////////////////////////////////////////////
	
	public String deleteTipPers(TipoPersona tp)  {
		try {
			tipPersBuss.deleteTipPers(tp.getTperId());
			loadListTipPers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
			Mensajes.addMessageInfo(tp.getTperNombre() + " ya tiene registros");
		}
		
		return null;
	}
	
	public void loadListTipPers() {
		try {
			listTipPers = tipPersBuss.getListTipPers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensajes.addMessageInfo(e.getMessage());
		}
		
	}

	public TipoPersona getNewTipoPersona() {
		return newTipoPersona;
	}

	public void setNewTipoPersona(TipoPersona newTipoPersona) {
		this.newTipoPersona = newTipoPersona;
	}

	public List<TipoPersona> getListTipPers() {
		return listTipPers;
	}

	public int getvTipPersID() {
		return vTipPersID;
	}

	public void setvTipPersID(int vTipPersID) {
		this.vTipPersID = vTipPersID;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}
	
	
	
	
}
