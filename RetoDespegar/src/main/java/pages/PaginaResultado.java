package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Esta libreria contiene los métodos de los objetos de la pantalla de
 * Resultados de la busquedad
 */
public class PaginaResultado {

	WebDriver driver;

	/**
	 * Metodo para ordenar los resultados de la busqueda
	 * 
	 * @throws InterruptedException
	 */
	public void ordenar() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"eva-select-1\"]/option[2]")).click();
		Thread.sleep(5000);
	}

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param driver
	 */
	public PaginaResultado(WebDriver driver) {
		this.driver = driver;
	}
}
