package com.gestor.excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static DataRequest ReadExcelFile(String filePath) throws Exception {

		try {

			File src = new File(filePath);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh1 = wb.getSheetAt(0);
			DataRequest datos = new DataRequest();
			datos.setNombres(sh1.getRow(1).getCell(0).getStringCellValue());
			datos.setApellidos(sh1.getRow(1).getCell(1).getStringCellValue());
			datos.setTipoDocumento(sh1.getRow(1).getCell(2).getStringCellValue());
			datos.setNumeroDocumento(sh1.getRow(1).getCell(3).getStringCellValue());
			datos.setFechaNacimiento(sh1.getRow(1).getCell(4).getStringCellValue());
			datos.setIngresos(sh1.getRow(1).getCell(5).getStringCellValue());
			datos.setCiudadDepartamento(sh1.getRow(1).getCell(6).getStringCellValue());
			wb.close();

			return datos;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
}
