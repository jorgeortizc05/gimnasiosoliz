package fusionsystem.jorgeortiz.gimnasiosoliz.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fusionsystem.jorgeortiz.gimnasiosoliz.model.Persona;

public class ExportExcel {
	
	
	public void writeExcelPersona(List<Persona> personas, String excelFilePath) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		int rowCount = 0;
		
		for(Persona persona: personas) {
			
			Row row = sheet.createRow(++rowCount);
			Cell cell = row.createCell(0);
			cell.setCellValue(persona.getCedula());
			
			cell = row.createCell(1);
			cell.setCellValue(persona.getNombres());
			
			
		}
		
		 try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
		        workbook.write(outputStream);
		  }
	}

}
