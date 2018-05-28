# Reto2. Pagina Despegar - Paquetes
### Descripción y contexto
---
Este proyecto de Automatización permite, seleccionar el menú Paquetes y realizar una búsqueda, de acuerdo con las condiciones que se envían en el feature. Una vez realizada la búsqueda, la información de los 10 paquetes más baratos se guarda en un archivo de Excel y se pinta el valor más barato. Los escenarios alternos se enfocaron a la validación de campos obligatorios de la página de búsqueda.

### Resumen de codificación
---
El código se encuentra documentado y la generación del Documento se realizó con JavaDoc. 
 	
### El framework
---
## BDD
Se utiliza BDD como framework de automatización para la automatización de los escenarios de prueba, la idea es escribir las pruebas antes de escribir el código fuente, pero en lugar de pruebas unitarias, lo que haremos será escribir pruebas que verifiquen que el comportamiento del código es correcto desde el punto de vista de negocio. Tras escribir las pruebas escribimos el código fuente de la funcionalidad que haga que estas pruebas pasen correctamente. Después refactorizamos el código fuente.
partimos de historias de usuario, siguiendo el modelo “Como [rol ] quiero [ característica ] para que [los beneficios]”. A partir de aquí, en lugar de describir en 'lenguaje natural' lo que tiene que hacer esa nueva funcionalidad, vamos a usar un lenguaje que nos va a permitir describir todas nuestras funcionalidades de una misma forma, un lenguaje específico para BDD.
## Gherkin
Se utiliza Gherkin como lenguaje de desarrollo de las funcionalidades dado que es un lenguaje comprensible por humanos y por ordenadores, con el vamos a definir el comportamiento de la página que vamos a automatizar.
Se trata de un lenguaje fácil de leer, fácil de entender y fácil de escribir. Utilizar Gherkin nos va a permitir crear una documentación viva a la vez que automatizamos los tests, haciéndolo además con un lenguaje que puede entender negocio. 
Lo bueno de Gherkin es que para empezar a hacer BDD sólo nos hace falta conocer 5 palabras, con las que construiremos sentencias con las que vamos a describir las funcionalidades:
- Feature: Indica el nombre de la funcionalidad que vamos a probar. Debe ser un título claro y explícito. Incluimos aquí una descripción en forma de historia de usuario: “Como [rol] quiero [característica] para que [los beneficios]”. Sobre esta descripción empezaremos a construir nuestros escenarios de prueba.
- Scenario: Describe cada escenario que vamos a probar.
-	Given: Provee contexto para el escenario en que se va a ejecutar el test, tales como punto donde se ejecuta el test, o prerequisitos en los datos. Incluye los pasos necesarios para poner al sistema en el estado que se desea probar.
-	When: Especifica el conjunto de acciones que lanzan el test. La interacción del usuario que acciona la funcionalidad que deseamos testear.
-	Then: Especifica el resultado esperado en el test. Observamos los cambios en el sistema y vemos si son los deseados.
Lo normal es probar distintos escenarios para comprobar una determinada funcionalidad. De esta forma vamos a pasar de nuestras historias de usuario a pruebas de comportamiento automatizables. 
## Cucumber
Se utiliza cucumber como herramienta para para automatizar las pruebas en BDD. Cucumber nos va permitir ejecutar descripciones funcionales en texto plano como pruebas de software automatizadas. Totalmente compatible con el lenguaje Gherkin.

#### Compilador
---
Se crea el proyecto sobre Gradel, es una herramienta de automatización de la construcción de nuestro código, es la versión mejorada de Maven, pero intenta llevarlo todo un paso más allá. Para empezar, se apoya en Groovy y en un DSL (Domain Specific Language) para trabajar con un lenguaje sencillo y claro a la hora de construir el build comparado con Maven. Por otro lado, dispone de una gran flexibilidad que permite trabajar con ella utilizando otros lenguajes y no solo Java. Dispone por otro lado de un sistema de gestión de dependencias sólido.

### Patrones de desarrollo
---
Para el desarrollo de la automatización se utilizaron los siguientes patrones de desarrollo:
Variables: camelCase
Funciones: camelCase
Clases: PascalCase
Paquetes: camelCase

Camel Case: El nombre viene porque se asemeja a las dos jorobas de un camello, y se puede dividir en dos tipos:
– Upper Camel Case, cuando la primera letra de cada una de las palabras es mayúscula. También denominado Pascal Case. Ejemplo: EjemploDeNomenclatura.
– Lower Camel Case, igual que la anterior con la excepción de que la primera letra es minúscula. Ejemplo: ejemploDeNomenclatura.
Es muy usada en los #hashTags de Twitter o en lenguajes como Java, PHP, C#…

### Prácticas de automatización
---
El proyecto se montó sobre el Modelo de Objeto de Proyecto (POM), con la siguiente estructura:
•	Src/main/java – en esta carpeta se tiene los paquetes de pages, runners, stepDefinitions y utilidades.
•	projectFeature – reserva.feature


### Herramienta de automatización utilizado
---
Se utiliza el IDE de Eclipse para el desarrollo de la automatización. Eclipse es una plataforma de desarrollo, diseñada para ser extendida de forma indefinida a través de plug-ins. Fue concebida desde sus orígenes para convertirse en una plataforma de integración de herramientas de desarrollo. No tiene en mente un lenguaje específico, sino que es un IDE genérico, aunque goza de mucha popularidad entre la comunidad de desarrolladores del lenguaje Java usando el plug-in JDT que viene incluido en la distribución estándar del IDE.
Proporciona herramientas para la gestión de espacios de trabajo, escribir, desplegar, ejecutar y depurar aplicaciones.

### Estrategia de automatización
---
Primero se realizó el smoke test de la funcionalidad que se requería probar, una vez identificada la forma de operar de la aplicación, creamos el proyecto con la estructura definida anteriormente y con las herramientas mencionadas.
Se procede a diseñar la historia de usuario en Gherkin, luego los stepsDefinitions, y la capturar los ID de los objetos con los que se requiere trabajar.
Se comienzan a desarrollar los métodos por cada paso y se procede a la implementación de los mismos.
Por último, la implementación del método que guarda en un archivo de Excel y los casos alterno.


### El navegador y la versión utilizada
---
El navegador utilizado fue: chrome=66.0 y el chromeDriver soportado para esta versión es chromedriver = 2.37. Para más información consultar página de compatibilidad (https://chromedriver.storage.googleapis.com/2.37/notes.txt).


## Las conclusiones de la automatización
---
Muy buen reto, para este caso puse en práctica todo lo que se aprendió en el curso de Selenium.
Los objetos no tenían ID, lo que dificulto un poco la identificación de los mismos, se debió hacer con xpath, aunque no es muy recomendado fue la única forma de capturarlos.
Sería muy bueno tener estos retos más seguidos, no se uno mensual, para no perder la práctica. Muy importante diseñarlos de manera que las personas refuercen los conocimientos y aprendan cosas nuevas, no por “corchar”.
