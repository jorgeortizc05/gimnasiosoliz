package fusionsystem.jorgeortiz.gimnasiosoliz.reporte;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.DbConexion;
import fusionsystem.jorgeortiz.gimnasiosoliz.util.Formato;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TarjetaGimnasio {
	
	//clase para ponerlo un formato, en este caso fecha.
	private Formato formato = new Formato();
		
	//Reporte adaptado para la factura del SRI
	public void generarTarjetaPorPersona(String cedula) throws JRException, IOException {
		//Establesco un mapa para ingresar un parametro tipo integer
		System.out.println(cedula);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("pv_cedula", cedula);
		
		//Genero una conexion, la libreria se llama web-inf/libcommons-core.jar 
		Connection conn = null;
		//Busca el archivo jasper y lo genera
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/gimnasiosoliz/reporte/tarjetaGimnasioPersona.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conn = DbConexion.getConexion());
		
		//Protocolo http para guardar en tiempo real el reporte
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=factura"+formato.formatoFecha()+".pdf");
		ServletOutputStream stream = response.getOutputStream();
		
		//exporta
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
		DbConexion.liberaConexion(conn);
    }
}
