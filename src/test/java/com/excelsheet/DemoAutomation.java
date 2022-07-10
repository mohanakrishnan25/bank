package com.excelsheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoAutomation {

	public static void main(String[] args) throws IOException {
File file = new File("C:\\Users\\mohan\\eclipse-workspace\\Frameworks\\Excel Sheets\\Testing.xlsx");
		
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("TEST");
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Select Skill");
		
		Row row2 = sheet.createRow(1);
		Cell cell2 = row2.createCell(0);
		cell2.setCellValue("Adobe InDesign");
		
		Row row3 = sheet.createRow(2);
		Cell cell3 = row3.createCell(0);
		cell3.setCellValue("Adobe Photoshop");
		
		Row row4 = sheet.createRow(3);
		Cell cell4 = row4.createCell(0);
		cell4.setCellValue("Analytics");
		
		Row row5 = sheet.createRow(4);
		Cell cell5 = row5.createCell(0);
		cell5.setCellValue("Android");
		
		Row row6 = sheet.createRow(5);
		Cell cell6 = row6.createCell(0);
		cell6.setCellValue("APIs");
		
		Row row7 = sheet.createRow(6);
		Cell cell7 = row7.createCell(0);
		cell7.setCellValue("Art Design");
		
		Row row8 = sheet.createRow(7);
		Cell cell8 = row8.createCell(0);
		cell8.setCellValue("AutoCAD");
		
		Row row9 = sheet.createRow(8);
		Cell cell9 = row9.createCell(0);
		cell9.setCellValue("Backup Management");

		Row row10 = sheet.createRow(9);
		Cell cell10 = row10.createCell(0);
		cell10.setCellValue("C");
		
		Row row11 = sheet.createRow(10);
		Cell cell11 = row11.createCell(0);
		cell11.setCellValue("C++");
		
		Row row12 = sheet.createRow(11);
		Cell cell12 = row12.createCell(0);
		cell12.setCellValue("Certifications");
		
		Row row13 = sheet.createRow(12);
		Cell cell13 = row13.createCell(0);
		cell13.setCellValue("Client Server");
		
		Row row14 = sheet.createRow(13);
		Cell cell14 = row14.createCell(0);
		cell14.setCellValue("Client Support");

		Row row15 = sheet.createRow(14);
		Cell cell15 = row15.createCell(0);
		cell15.setCellValue("Configuration");
		

		Row row16 = sheet.createRow(15);
		Cell cell16 = row16.createCell(0);
		cell16.setCellValue("Content Managment");
		

		Row row17 = sheet.createRow(16);
		Cell cell17 = row17.createCell(0);
		cell17.setCellValue("Content Management Systems (CMS)");
		

		Row row18 = sheet.createRow(17);
		Cell cell18 = row18.createCell(0);
		cell18.setCellValue("Corel Draw");
		

		Row row19 = sheet.createRow(18);
		Cell cell19 = row19.createCell(0);
		cell19.setCellValue("Corel Word Perfect");
		

		Row row20 = sheet.createRow(19);
		Cell cell20 = row20.createCell(0);
		cell20.setCellValue("CSS");
		

		Row row21 = sheet.createRow(20);
		Cell cell21 = row21.createCell(0);
		cell21.setCellValue("Data Analytics");
		

		Row row22 = sheet.createRow(21);
		Cell cell22 = row22.createCell(0);
		cell22.setCellValue("Desktop Publishing");
		
		
		
		
		FileOutputStream o= new FileOutputStream(file);
		workbook.write(o);
	}

}
