package com.excelsheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation2 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement dDnSkills=driver.findElement(By.id("Skills"));		
		Select select = new Select(dDnSkills);
		List<WebElement> list = select.getOptions();
		File file = new File("C:\\Users\\mohan\\eclipse-workspace\\Frameworks\\Excel Sheets\\Testing.xlsx");
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("TEST");
		System.out.println("***********");
		for (int i = 0; i < list.size(); i++) {
			WebElement e = list.get(i);
			String text = e.getText();
			
			Row row = sheet.createRow(i);
			System.out.println(i);
			
			Cell cell = row.createCell(0);
			cell.setCellValue(text);
			System.out.println(text);
			FileOutputStream o= new FileOutputStream(file);
			workbook.write(o);	
			System.out.println("********");
		}		
		driver.quit();
		
	}
}
