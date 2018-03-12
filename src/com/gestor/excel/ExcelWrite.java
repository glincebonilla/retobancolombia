package com.gestor.excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void createExcelFile(String filePath, String americanCreditCard, String masterBlack)
			throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("infotarjetas");
		Row infoRow = sheet.createRow(0);

		Cell cellAmerican = infoRow.createCell(0);
		cellAmerican.setCellValue(americanCreditCard);

		Cell cellMasterBlack = infoRow.createCell(1);
		cellMasterBlack.setCellValue(masterBlack);

		sheet.autoSizeColumn(0);

		sheet.autoSizeColumn(1);

		FileOutputStream fileOut = new FileOutputStream(filePath);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();

	}
}
