package com.redirect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class URLVerification {

	WebDriver driver;

	//@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/servers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	//@Test
	public void verify() throws IOException{
		//File file = new File("C:/Users/MR788s/Documents/FinalReport.xlsx");
		FileInputStream fis = new FileInputStream("C:/Users/MR788s/Documents/FinalReport.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		
		FileInputStream fis2 = new FileInputStream("C:/Users/MR788s/Documents/FinalReportTest.xlsx");
		Workbook workbook2 = new XSSFWorkbook(fis2);
		Sheet sheet2 = workbook2.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows in sheet are: " + rowCount);

		for(int i = 1; i <= rowCount-1; i++) {

			Row row = sheet.getRow(i);
			String url = row.getCell(0).getStringCellValue();
			System.out.println(url);
			driver.get(url);
			
			String currentURL = driver.getCurrentUrl();
			String title = driver.getTitle();
			
			if(title.equals("Page Not Found. Error 404")) {
				System.out.println("404 found");
				
				Row row2 = sheet2.createRow(i);
				Cell cell1 = row2.createCell(0);
				Cell cell2 = row2.createCell(1);
				
				cell1.setCellValue(url);
				cell2.setCellValue("Page Not Found. Error 404");
			}
			else if(currentURL.equals(url) && title != "Page Not Found. Error 404") {
				System.out.println("current same and page 404 is not there");
				Row row2 = sheet2.createRow(i);
				Cell cell1 = row2.createCell(0);
				Cell cell2 = row2.createCell(1);
				
				cell1.setCellValue(url);
				cell2.setCellValue("Same URL, not redirecting");				
			}
			else if(currentURL != url && title != "Page Not Found. Error 404") {
				System.out.println("current same and page 404 is not there");
				Row row2 = sheet2.createRow(i);
				Cell cell1 = row2.createCell(0);
				Cell cell2 = row2.createCell(1);
				Cell cell3 = row2.createCell(2);
				
				cell1.setCellValue(url);
				cell2.setCellValue("Redirecting");			
				cell3.setCellValue(currentURL);
			}	
		}
		
		FileOutputStream fos = new FileOutputStream("C:/Users/MR788s/Documents/FinalReportTest.xlsx");
		workbook2.write(fos);
		fos.close();
		System.out.println("END OF WRITING DATA IN EXCEL");


	}

}
