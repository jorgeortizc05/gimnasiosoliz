package fusionsystem.jorgeortiz.gimnasiosoliz.util;

public class UbicacionArchivo {
	private static String pathReportesJasper = "C:\\Users\\gimnasio\\Documents\\MEGA\\GIMNASIOSOLIZ\\reportes\\";
	private static String pathDescargaReportes = "C:\\Users\\gimnasio\\Documents\\MEGA\\GIMNASIOSOLIZ\\reportes\\";
	private static String pathCopiaSeguridadDatos = "C:\\Users\\gimnasio\\Documents\\MEGA\\GIMNASIOSOLIZ\\reportes\\";
	private static String pathSonido = "/fusionsystem/jorgeortiz/gimnasiosoliz/efecto-sonido/";
	private static String pathOrigenFotos = "/fusionsystem/jorgeortiz/gimnasiosoliz/fotos-socios/";
	
	
	public static String getPathOrigenFotos() {
		return pathOrigenFotos;
	}
	public static void setPathOrigenFotos(String pathOrigenFotos) {
		UbicacionArchivo.pathOrigenFotos = pathOrigenFotos;
	}
	public static String getPathDescargaReportes() {
		return pathDescargaReportes;
	}
	public static void setPathDescargaReportes(String pathDescargaReportes) {
		UbicacionArchivo.pathDescargaReportes = pathDescargaReportes;
	}
	public static String getPathCopiaSeguridadDatos() {
		return pathCopiaSeguridadDatos;
	}
	public static void setPathCopiaSeguridadDatos(String pathCopiaSeguridadDatos) {
		UbicacionArchivo.pathCopiaSeguridadDatos = pathCopiaSeguridadDatos;
	}
	public static String getPathReportesJasper() {
		return pathReportesJasper;
	}
	public static void setPathReportesJasper(String pathReportesJasper) {
		UbicacionArchivo.pathReportesJasper = pathReportesJasper;
	}
	public static String getPathSonido() {
		return pathSonido;
	}
	public static void setPathSonido(String pathSonido) {
		UbicacionArchivo.pathSonido = pathSonido;
	}

	
	
	
}
