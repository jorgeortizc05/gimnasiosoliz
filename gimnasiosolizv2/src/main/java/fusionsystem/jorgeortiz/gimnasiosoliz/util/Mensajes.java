package fusionsystem.jorgeortiz.gimnasiosoliz.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class Mensajes {
	
	public static void addMessageInfo(String summary) {
		FacesMessage messsage = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, messsage);
	}
	
	public static void addMessageWarn(String summary) {
		FacesMessage messsage = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, messsage);
	}
	
	public static void addMessageFatal(String summary) {
		FacesMessage messsage = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, messsage);
	}
	
	public static void addMessageError(String summary) {
		FacesMessage messsage = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, messsage);
	}
}
