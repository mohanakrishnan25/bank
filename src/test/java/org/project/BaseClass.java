package org.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	//1
	public void getDriver() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	}
	//2
	public void loadUrl(String url) {
			driver.get(url);
	
		
	}
	//3
	public void maximize() {
		driver.manage().window().maximize();
	}
	//4
	public void type(WebElement element,String data) {
		element.sendKeys(data);
	}
	//5
	public void click(WebElement element) {
		element.click();
	}
	//6
	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	//7
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
	//8
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	//9
	public WebElement findElementByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}
	//10
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	//11
	public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	//12
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	//13
	public void closeWindow() {
		driver.close();
	}
	//14
	public void closeAllWindow() {
		driver.quit();
	}
	//15
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	//16
	public String getAttributeValue(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	//17
	public void selectOptionByText(WebElement element, String text) {
		Select select=new Select (element);
		select.selectByVisibleText(text);
	}
	//18
	public void selectOptionByIndex(WebElement element, int index) {
		Select select=new Select (element);
		select.selectByIndex(index);
	}
	//19
	public void selectOptionValue(WebElement element, String value) {
		Select select=new Select (element);
		select.selectByValue(value);
	}
	//20
	public void selectFirstSelectedOptionDropdown(WebElement element) {
		Select select=new Select (element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
	}
	//21
	public void deselectByIndex(WebElement element, int index) {
		Select select=new Select (element);
		select.deselectByIndex(index);
	}
	//22
	public void deselectAll(WebElement element, String text) {
		Select select=new Select (element);
		select.deselectAll();
	}
	//23
	public void isMultiple(WebElement element, Boolean b) {
		Select select=new Select (element);
		boolean multiple = select.isMultiple();
	}
	//24
	public void deselectByText(WebElement element, String text) {
		Select select=new Select (element);
		select.deselectByVisibleText(text);
	}
	//25
	public void deselectByValue(WebElement element, String value) {
		Select select=new Select (element);
		select.deselectByValue(value);
	}
	//26
	public List<WebElement> selectAllOptions(WebElement element, String text) {
		Select select=new Select (element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}
	//27
	public void typeJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','+text+')", element);
	}
	//28
	public void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	//29
	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)",element);
	}
	//30
	public void typeAlertAccept() {
		Alert a =driver.switchTo().alert();
		a.accept();
	}
	//31
	public void typeAlertDismiss() {
		Alert a =driver.switchTo().alert();
		a.dismiss();
	}
	//32
	public Timeouts implicitwait() {
		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return implicitlyWait;
	}
	//33
	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	//34
	public  Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	//35
	public WebDriver switchFrame(WebElement element) {
		WebDriver frame = driver.switchTo().frame(element);
		return frame;
	}
	//36
	public WebDriver switchDefaultContent(WebElement element) {
		WebDriver defaultContent = driver.switchTo().defaultContent();
		return defaultContent;
	}
	//37
	public void takeScreenshot(WebElement element, String pathname) throws IOException {
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File(pathname);
		FileUtils.copyFile(s, d);
	}
	//38
	public void robotKeyPress(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keycode);
	}
	//39
	public void robotKeyRelease(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(keycode);
	}
	//40
	public void actionMoveTOElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	//41
	public Actions actiondragAndDrop(WebElement source, WebElement destination) {
		Actions action = new Actions(driver);
		Actions dragAndDrop = action.dragAndDrop(source, destination);
		return dragAndDrop;
	}
	//42
	public Actions actionDoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		Actions doubleClick = action.doubleClick(element);
		return doubleClick;
	}
	//43
	public Actions clickAndHold(WebElement element) {
		Actions action = new Actions(driver);
		Actions clickAndHold = action.clickAndHold(element);
		return clickAndHold;
	}
	//44
	public Actions contextClick(WebElement element) {
		Actions action= new Actions(driver);
		Actions contextClick = action.contextClick(element);
		return contextClick;
	}
	//45
	public Actions actionSendKeys(WebElement element, String text) {
		Actions action = new Actions(driver);
		Actions sendKeys = action.sendKeys(element, text);
		return sendKeys;
	}
	//46
	public Alert explicitWaitAlertispresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert until = wait.until(ExpectedConditions.alertIsPresent());
		return until;
	}
	//47
	public WebElement elementSectionStateToBe(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(element));
		return until;
	}
	//48
	public boolean elementToBeSelected(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean until = wait.until(ExpectedConditions.elementToBeSelected(element));
		return until;
	}
	//49
	public WebElement visibilityOfElementLocated(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
		return until;
	}
	//50
	public boolean titleContains(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean until = wait.until(ExpectedConditions.titleContains(title));
		return until;
	}
	//51
	public boolean textToBePresentInElementLocated(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean until = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		return until;
	}
	//52
	public WebElement visibilityOf(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
		return until;
	}
	//53
	public boolean titleIs(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean until = wait.until(ExpectedConditions.titleIs(title));
		return until;
	}
	//54
	public List<WebElement> visibilityOfAllElement(WebElement elements) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> until = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		return until;
	}
	//55
	public boolean invisibilityOfElementLocated(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean until = wait.until(ExpectedConditions.invisibilityOf(element));
		return until;
	}
	//56
	public Boolean textToBrPresentInElementValue(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Boolean until = wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		return until;
	}
	//57
	public String getData(String pathname, String sheetName, int rownum, int cellnum ) throws IOException {
		String res=null;
		File file = new File(pathname);
		FileInputStream stream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch(cellType) {
		case STRING:
			 res = cell.getStringCellValue();
			 break;
		case NUMERIC:
		 if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				res = format.format(dateCellValue);
			  }
		 else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal d = BigDecimal.valueOf(numericCellValue);
				res=d.toString();
			  }
		 	break;
		}
		return res;
					
	}
	//58
	public void repalceData(String pathname, String sheetName, int rownum, int cellnum, String oldData, String newData) throws IOException {
		File file = new File(pathname);
		FileInputStream stream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		if(cell.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream output= new FileOutputStream(file);
		workbook.write(output);
	}
	//59
	public void createCell(String pathname, String sheetName, int rownum, int cellnum, String newData) throws IOException {
		File file = new File(pathname);
		FileInputStream stream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newData);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}
	//60
	public void createRowCell(String pathname, String sheetName, int rownum, int cellnum, String newData) throws IOException {
		File file = new File(pathname);
		FileInputStream stream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newData);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}
	//61
	public void createWorkbook(String pathname, String sheetName, int rownum, int cellnum, String newData) throws IOException {
		File file = new File(pathname);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newData);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}
		






































}



























































