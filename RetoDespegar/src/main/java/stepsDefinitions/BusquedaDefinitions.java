
package stepsDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PaginaBusqueda;
import pages.PaginaResultado;
import utilidades.Utilidades;

/**
 * Esta libreria contiene los Definitions y Steps del Gherkin
 * 
 * @author RZABALA
 *
 */
public class BusquedaDefinitions {
	WebDriver driver;
	PaginaBusqueda paginaBusqueda;
	PaginaResultado paginaResultado;
	Utilidades uti;

	@Before
	/**
	 * Metodo para la inicialización del Driver, en este caso el ChromeDriver y la
	 * inicialización de las clases con las que vamos a trabajar
	 */
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "D:/Users/rzabala/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		paginaBusqueda = new PaginaBusqueda(driver);
		paginaResultado = new PaginaResultado(driver);
		uti = new Utilidades(driver);
	}

	/**
	 * Metodo para ingresar a la pagina principal
	 */
	@Given("el usuario esta en la pagina de Despegar")
	public void ingresoURL() {
		driver.get("https://www.despegar.com.co/");
		paginaBusqueda.btnCerrarVentana();
		driver.manage().window().maximize();
		System.out.println("el usuario esta en la pagina de Despegar");

	}

	/**
	 * Metodo para ingresar a la pagina de Paquetes
	 */
	@And("el usuario esta en la opcion Paquetes")
	public void opcionPaquete() throws InterruptedException {
		paginaBusqueda.btnOpcion();
		System.out.println("el usuario esta en la Opción Paquetes");
	}

	/**
	 * Metodo para ingresar a ciudad origen en el formulario
	 */
	@When("el usuario ingresa la ciudad origen \"(.*)\"$")
	public void usuarioIngresaCiudadOrigen(String ciudadOrigen) throws InterruptedException {
		paginaBusqueda.txtCiudadOrigen(ciudadOrigen);
		System.out.println("el usuario ingresa la ciudad origen");
	}

	/**
	 * Metodo para ingresar a ciudad destino en el formulario
	 */
	@And("el usuario ingresa la ciudad destino \"(.*)\"$")
	public void usuarioIngresaCiudadDestino(String ciudadDestino) throws InterruptedException {
		paginaBusqueda.txtCiudadDestino(ciudadDestino);
		System.out.println("el usuario ingresa la ciudad destino");
	}

	/**
	 * Metodo para ingresar a fecha de partida en el formulario
	 */
	@And("el usuario ingresa fecha partida \"(.*)\"$")
	public void usuarioIngresaFechaPartida(String fechaPartida) throws InterruptedException {
		paginaBusqueda.txtFechaPartida(fechaPartida);
		System.out.println("el usuario ingresa fecha partida valida");
	}

	/**
	 * Metodo para ingresar a fecha de regreso en el formulario
	 */
	@And("el usuario ingresa fecha regreso \"(.*)\"$")
	public void usuarioIngresaFechaRegreso(String fechaRegreso) throws InterruptedException {
		paginaBusqueda.txtFechaRegreso(fechaRegreso);
		System.out.println("el usuario ingresa fecha regreso valida");
	}

	/**
	 * Metodo para presionar el boton guardar en el formulario
	 */
	@And("el usuario presiona boton buscar")
	public void usuarioPresionaBotonBuscar() {
		paginaBusqueda.btnBuscar();
		System.out.println("el usuario presiona boton buscar");
	}

	/**
	 * Metodo para ordenar la consulta de la busqueda
	 */
	@And("ordenar por menor precio")
	public void ordenar() throws InterruptedException {
		paginaResultado.ordenar();
		System.out.println("ordena");
	}

	/**
	 * Metodo para guardar en excel la consulta ordenada
	 */
	@Then("guardar en archivo excel")
	public void guardarArchivoExcel() throws Exception {
		uti.seleccionarResultados();
		System.out.println("crear archivo y marca en verde el mas barato");
	}

	/**
	 * Metodo para validaciones de los campos obligatorios - ciudad origen
	 */
	@Then("muestra mensaje de validacion Ingresa un origen.")
	public void mensajeValidacionIngresaOrigen() throws InterruptedException {
		Thread.sleep(3000);
		String msgValidacion = paginaBusqueda.msgIngresaOrigen();
		assertEquals("Ingresa un origen.", msgValidacion);
		System.out.println("muestra mensaje de validacion Ingresa un origen.");
	}

	/**
	 * Metodo para validaciones de los campos obligatorios - ciudad destino
	 */
	@Then("muestra mensaje de validacion El destino deben ser diferente al origen.")
	public void mensajeValidacionIngresaDestino() throws InterruptedException {
		Thread.sleep(3000);
		String msgValidacion = paginaBusqueda.msgIngresaDestino();
		assertEquals("El destino debe ser diferente del origen.", msgValidacion);
		System.out.println("muestra mensaje de validacion El destino deben ser diferente al origen.");
	}

	/**
	 * Metodo para validaciones de los campos obligatorios - fecha de partida
	 */
	@Then("muestra mensaje de validacion Ingresa una fecha de partida.")
	public void mensajeIngresaFechaPartida() throws InterruptedException {
		Thread.sleep(3000);
		String msgValidacion = paginaBusqueda.msgIngresaFechaPartida();
		assertEquals("Ingresa una fecha de partida.", msgValidacion);
		System.out.println("muestra mensaje de validacion Ingresa una fecha de partida.");
	}

	/**
	 * Metodo para validaciones de los campos obligatorios - fecha de regreso
	 */
	@Then("muestra mensaje de validacion Ingresa una fecha de regreso.")
	public void mensajeIngresaFechaRegreso() throws InterruptedException {
		Thread.sleep(3000);
		String msgValidacion = paginaBusqueda.msgIngresaFechaRegreso();
		assertEquals("Ingresa una fecha de regreso.", msgValidacion);
		System.out.println("muestra mensaje de validacion Ingresa una fecha de regreso.");
	}

	/**
	 * Metodo para cerrar la ventana una vez ejecutado el escenario
	 */
	@After
	public void tearDown() {
		driver.quit();
	}
}