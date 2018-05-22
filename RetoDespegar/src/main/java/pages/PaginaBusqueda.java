package pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaBusqueda{
	WebDriver driver;
    Calendar fecha = Calendar.getInstance();
    int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH) + 1;

    //Cerrar ventana inicial
	public void btnCerrarVentana() {
		
		if (driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span")).isEnabled()) {
			driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span")).click();			
		}		
	}
	
	public void txtCiudadOrigen(String ciudadOrigen) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input")).sendKeys(ciudadOrigen);
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	}
	public void txtCiudadDestino(String ciudadDestino) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(ciudadDestino);
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	}
	public void txtFechaPartida(String fechaPartida) throws InterruptedException{
		int dia = Dia(fechaPartida);
		int mes = Mes(fechaPartida);
		
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[1]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/i")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div["+ mes + "]/div[4]/span[" + dia + "]")).click();
	}
	
	public void txtFechaRegreso(String fechaRegreso) throws InterruptedException {
		int dia = Dia(fechaRegreso);
		int mes = Mes(fechaRegreso);
		
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[2]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div["+ mes + "]/div[4]/span[" + dia + "]")).click();
	}
	public void btnBuscar() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[5]/div/a/em")).click();
	}
	public String msgIngresaOrigen() {
		return driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/span")).getText();
	}	
	public String msgIngresaDestino() {
		return driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/span[2]")).getText();
	}	
	public String msgIngresaFechaPartida() {
		return driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[1]/div/span[2]")).getText();
	}	
	public String msgIngresaFechaRegreso() {
		return driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[2]/div[1]/div[2]/div[2]/div/span[2]")).getText();
	}	
	public PaginaBusqueda(WebDriver driver) {
		this.driver = driver;
	}
	public int Mes(String fechaEnviada)
	{
	    String[] fechaDesglosada = fechaEnviada.split("/");
        int contadorMes = Integer.parseInt(fechaDesglosada[1]) - mes + 1;
		return contadorMes;	
	}
	
	public int Dia(String fechaEnviada1)
	{
        String[] fechaDesglosada = fechaEnviada1.split("/");
        int dia = Integer.parseInt(fechaDesglosada[0]);
        return dia;
	}
	
	
}
