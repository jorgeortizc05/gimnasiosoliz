package fusionsystem.jorgeortiz.gimnasiosoliz.util;

import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;

public class Formato {

	public String formatoFecha() {
		Date fecha = new Date();
		String vFecha = new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(fecha);
		String vFechaSinEspacio = vFecha.replace(" ", "");
		
		return vFechaSinEspacio;
	}
}
