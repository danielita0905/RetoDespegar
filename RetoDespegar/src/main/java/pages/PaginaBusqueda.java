package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utilidades.Utilidades;

/**
 * Esta libreria contiene los métodos de los objetos de la primera pantalla
 * donde se realiza la busquedad,  en esta pagina van los ID o xpath de los objetos
 * 
 * @author RZABALA
 *
 */
public class PaginaBusqueda {
	WebDriver driver;
	Utilidades uti = new Utilidades(driver);

	/**
	 * Cierra la ventana publicitaria
	 */
	public void btnCerrarVentana() {
		if (driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span")).isEnabled()) {
			driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span")).click();
		}
	}

	/**
	 * Opción del Menu, implementada para la opción Paquete
	 */
	public void btnOpcion() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/ul/li[3]/a/span[2]")).click();
		Thread.sleep(3000);
	}

	/**
	 * Metodo para el ingreso de la ciudad origen en el formulario de busqueda
	 * 
	 * @param ciudadOrigen:
	 *            parametro que trae la data de la prueba
	 * @throws InterruptedException
	 */
	public void txtCiudadOrigen(String ciudadOrigen) throws InterruptedException {
		driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input"))
				.clear();
		if (ciudadOrigen != "") {
			driver.findElement(By.xpath(
					"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input"))
					.sendKeys(ciudadOrigen);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input"))
				.sendKeys(Keys.ENTER);
	}

	/**
	 * Metodo para el ingreso de la ciudad destoo en el formulario de busqueda
	 * 
	 * @param ciudadDestino:
	 *            parametro que trae la data de la prueba
	 * @throws InterruptedException
	 */
	public void txtCiudadDestino(String ciudadDestino) throws InterruptedException {
		driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input"))
				.clear();
		if (ciudadDestino != "") {
			driver.findElement(By.xpath(
					"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input"))
					.sendKeys(ciudadDestino);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input"))
				.sendKeys(Keys.ENTER);
	}

	/**
	 * Metodo para el ingreso de la fecha de partida en el formulario de busqueda
	 * 
	 * @param fechaPartida:
	 *            parametro que trae la data de la prueba
	 * @throws InterruptedException
	 */
	public void txtFechaPartida(String fechaPartida) throws InterruptedException {
		int dia = uti.Dia(fechaPartida);
		int mes = uti.Mes(fechaPartida);

		driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[1]/div/input"))
				.click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div[" + mes + "]/div[4]/span[" + dia + "]")).click();
	}

	/**
	 * Metodo para el ingreso de la fecha de regreso en el formulario de busqueda
	 * 
	 * @param fechaRegreso:
	 *            parametro que trae la data de la prueba
	 * @throws InterruptedException
	 */
	public void txtFechaRegreso(String fechaRegreso) throws InterruptedException {
		int dia = uti.Dia(fechaRegreso);
		int mes = uti.Mes(fechaRegreso);

		driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[2]/div/input"))
				.click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div[" + mes + "]/div[4]/span[" + dia + "]")).click();
	}

	/**
	 * Metodo para presionar el boton Buscar en el formulario de busqueda
	 */
	public void btnBuscar() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[5]/div/a/em")).click();
	}

	/**
	 * Metodo que captura el mensaje de validación cuando no se ingresa ciudad
	 * origen en el formulario
	 * 
	 * @return retorna el mensaje de validacion que se muestra en pantalla
	 */
	public String msgIngresaOrigen() {
		return driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/span"))
				.getText();
	}

	/**
	 * Metodo que captura el mensaje de validación cuando no se ingresa ciudad
	 * destino en el formulario
	 * 
	 * @return retorna el mensaje de validacion que se muestra en pantalla
	 */
	public String msgIngresaDestino() {
		return driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/span[2]"))
				.getText();
	}

	/**
	 * Metodo que captura el mensaje de validación cuando no se ingresa fecha de
	 * partida en el formulario
	 * 
	 * @return retorna el mensaje de validacion que se muestra en pantalla
	 */
	public String msgIngresaFechaPartida() {
		return driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[1]/div/span[2]"))
				.getText();
	}

	/**
	 * Metodo que captura el mensaje de validación cuando no se ingresa fecha de
	 * partida en el formulario
	 * 
	 * @return retorna el mensaje de validacion que se muestra en pantalla
	 */
	public String msgIngresaFechaRegreso() {
		return driver.findElement(By.xpath(
				"//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[2]/div/span[2]"))
				.getText();
	}

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param driver
	 */
	public PaginaBusqueda(WebDriver driver) {
		this.driver = driver;
	}

}
