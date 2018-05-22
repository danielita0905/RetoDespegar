package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//imports de escritura en excel
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;


public class PaginaResultado {

	WebDriver driver;
	//Cerrar ventana inicial
	
	public void ordenar() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"eva-select-1\"]/option[2]")).click();
		Thread.sleep(5000);
	}
	
	public void seleccionarResultados() throws Exception
	{
		String excelFileName = "C:\\Users\\rzabala\\eclipse-workspace\\RetoDespegar\\Resultado.xls";
		String sheetName = "Resultado";
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);

		
		HSSFSheet sheet1 = wb.getSheetAt(0);
		
		for(int i=0;i<=10;i++)
		{
			HSSFRow row = sheet.createRow(i);
			List<WebElement> precios;
			
			precios = this.driver.findElements(By.xpath("//span[@class='person-price']"));
			HSSFCell cell = row.createCell(1);
			
			if (i == 0) { 
				
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont font = wb.createFont();
				font.setColor(HSSFColor.GREEN.index);
				style.setFont(font);

				cell.setCellStyle(style);
				
		
			}
			
			String tx = precios.get(i).getText();
			cell.setCellValue(precios.get(i).getText());
		}
		// Creamos el estilo de celda del color VERDE
		 // Aplicamos el estilo correspondiente VERDE	     
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();     		
	}
	
	public void pintarcelda() {
		String excelFileName = "C:\\Users\\rzabala\\eclipse-workspace\\RetoDespegar\\Resultado.xls";
		String sheetName = "Resultado";
		HSSFWorkbook wb = new HSSFWorkbook(); 
		HSSFSheet sheet = wb.createSheet(sheetName) ;
		
		
	}
	public PaginaResultado(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Function escritura excel
}
