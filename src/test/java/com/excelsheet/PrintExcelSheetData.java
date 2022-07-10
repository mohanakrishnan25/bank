package com.excelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrintExcelSheetData {
	public static void main(String[] args) throws IOException{
		File file = new File("C:\\Users\\mohan\\eclipse-workspace\\Frameworks\\Excel Sheets\\velsbusinessclub.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("TestData");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			System.out.println();
			for (int j = 0; j <row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(j);
				
			CellType type = cell.getCellType();
			switch (type){
				case STRING:
					String s = cell.getStringCellValue();
					System.out.print(s+"\t");
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell))
					{	Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat date= new SimpleDateFormat("dd/MMM/YYYY");
						String format = date.format(dateCellValue);
						System.out.print(format+"\t");
					}
					else {
						double d = cell.getNumericCellValue();
						BigDecimal b= BigDecimal.valueOf(d);
						String v = b.toString();
						System.out.print(v+"\t");
						
					}
						break;

					}
					}
		
			}
			
}
}
	
