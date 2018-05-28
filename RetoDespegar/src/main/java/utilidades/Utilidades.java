package utilidades;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Esta libreria contiene los métodos construidos para las validaciones de las
 * pruebas diseñadas
 * 
 * @author RZABALA
 *
 */
public class Utilidades {
	WebDriver driver;

	Calendar fecha = Calendar.getInstance();
	int mes = fecha.get(Calendar.MONTH) + 1;

	/**
	 * Metodo para identificar el mes que se debe buscar en el calendario apartir de
	 * la fecha enviada desde el feature
	 * 
	 * @param fechaEnviada
	 *            fecha enviada en el feature
	 * @return
	 */
	public int Mes(String fechaEnviada) {
		String[] fechaDesglosada = fechaEnviada.split("/");
		int contadorMes = Integer.parseInt(fechaDesglosada[1]) - mes + 1;
		return contadorMes;
	}

	/**
	 * Metodo para identificar el dia que se debe buscar en el calendario apartir de
	 * la fecha enviada desde el feature
	 * 
	 * @param fechaEnviada1
	 *            fecha enviada en el feature
	 * @return
	 */
	public int Dia(String fechaEnviada1) {
		String[] fechaDesglosada = fechaEnviada1.split("/");
		int contadorDia = Integer.parseInt(fechaDesglosada[0]);
		return contadorDia;
	}

	/**
	 * Metodo para recorrer los precios de la busqueda y guardarlos en un archivo de
	 * Excel, pintando de verde el mas barato.
	 */
	public void seleccionarResultados() throws Exception {
		// Crear el archivo de excel
		String excelFileName = "C:\\Users\\rzabala\\eclipse-workspace\\RetoDespegar\\Resultado.xls";
		String sheetName = "Resultado";
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		Thread.sleep(5000);

		// Cargar la lista de precios
		List<WebElement> precios;
		precios = this.driver.findElements(By.xpath("//span[@class='person-price']"));

		for (int i = 0; i <= 10; i++) {
			HSSFRow row = sheet.createRow(i);
			HSSFCell cell = row.createCell(0);

			// Pintar el texto del precio mas barato
			if (i == 0) {
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont font = wb.createFont();
				font.setColor(HSSFColor.GREEN.index);
				style.setFont(font);
				cell.setCellStyle(style);
			}
			// Asignar el valor a la celda
			String tx = precios.get(i).getText();
			cell.setCellValue(precios.get(i).getText());
		}
		// Cerrar Archivo de Excel
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param driver
	 */
	public Utilidades(WebDriver driver) {
		this.driver = driver;
	}

}
