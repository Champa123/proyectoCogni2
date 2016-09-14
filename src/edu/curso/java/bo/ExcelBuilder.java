package edu.curso.java.bo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelBuilder extends AbstractExcelView {
	
		
			


	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Proyecto> proyectos2 = (List<Proyecto>) model.get("proyectos2");
		
		HSSFSheet sheet = workbook.createSheet("Java Books");
        sheet.setDefaultColumnWidth(30);
        
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        
        
        HSSFRow header = sheet.createRow(0);
        
        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);
         
        
        header.createCell(1).setCellValue("Nombre");
        header.getCell(1).setCellStyle(style);
        
        header.createCell(2).setCellValue("Descripción");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Fecha de inicio");
        header.getCell(3).setCellStyle(style);
        
        header.createCell(4).setCellValue("Fecha de finalización");
        header.getCell(4).setCellStyle(style);
         
        header.createCell(5).setCellValue("Usuario principal");
        header.getCell(5).setCellStyle(style);
        
        header.createCell(6).setCellValue("Horas asignadas");
        header.getCell(6).setCellStyle(style);
        
        header.createCell(7).setCellValue("Horas disponibles");
        header.getCell(7).setCellStyle(style);
        
        int rowCount = 1;
        
        for (Proyecto aProyecto : proyectos2) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(aProyecto.getId());
            aRow.createCell(1).setCellValue(aProyecto.getNombre());
            aRow.createCell(2).setCellValue(aProyecto.getDescripcion());     
            aRow.createCell(3).setCellValue(aProyecto.getFechaInicio());
            aRow.createCell(4).setCellValue(aProyecto.getFechaFin());
            Usuario usuarioPpal= aProyecto.getUsuarioPrincipal();
            aRow.createCell(5).setCellValue(usuarioPpal.getNombreCompleto());
            aRow.createCell(6).setCellValue(aProyecto.getHorasAsignadas());
            aRow.createCell(7).setCellValue(aProyecto.getHorasAsignadas() - aProyecto.getSumaHorasTareas()); 
            
	}
        
	}

}

