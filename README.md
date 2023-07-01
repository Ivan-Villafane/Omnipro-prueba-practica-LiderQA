# Omni.pro - Prueba Práctica - Líder QA

## Iván Darío Villafañe Pérez

Este proyecto se realiza con el fin de elaborar un Framework de automatización de pruebas basado en Selenium WebDriver de acuerdo con los requerimientos de la prueba.

Elaboro el Framework con todas las funcionalidades necesarias para abordar la automatización de pruebas web con Selenium con una estructura que permite reducir tiempos en la construcción y posible reutilización para diversos proyectos.

## Inicio de la prueba 🚀

Con el ánimo de tener un proyecto reutilizable con el cual podamos clonar o copiar parte de los casos de prueba, se reliza la prueba en las páginas web: https://qalified.com/ Y https://katalon-demo-cura.herokuapp.com utilizando la primera para complementar los conocimientos de automatización y cumpliendo los requisitos de la prueba.

## Diseño de pruebas ⚙️

A continuación, informo y detallo cómo realicé la creación de las pruebas automatizadas usando deversas clases y métodos.

### Primeros pasos

Creé la primera clase de pruebas utilizando la opción  _File > New > Class_. Esta clase de pruebas contiene los distintos métodos de prueba que se generaron en el proyecto.

Las clases de prueba son extendidas de la clase  _ TestBase _  donde se resuelve la creación del driver y el manejador de propiedades de forma totalmente automática.
 
```java
public class Omnipro_Test1_NavegarQAlified extends TestBase {

}

```

Se crearon las pruebas automatizadas con un método público dentro de la clase de prueba con la anotación  _@Test_ .


```java
public class Omnipro_Test1_NavegarQAlified extends TestBase {

	@Test
	public void sampleTestCase {

		//script...

	}

}
```

Utilizando el objeto  _WebAutomator_  heredado de la clase TestBase accedí a las principales funcionalidades de navegación en la dirección URL mencionada anteriormente, navegar hacia atrás y adelante, refrescar la página y cerrar el navegador.

```java
package test;

import org.testng.annotations.Test;

public class Omnipro_Test1_NavegarQAlified extends TestBase {
	
	@Test
	public void sampleTestCase() {
		String testUrl = "https://qalified.com/";
		automator.goTo(testUrl); // Permite navegar a una URL
		automator.back(); // Permite navegar hacia atras
		automator.forward(); // Permite navegar hacia adelante
		automator.refresh(); // Permite recargar la página
		automator.closeBrowser(); // Permite cerrar el navegador
	}

}
```

### Interacción con elementos de la web

Utilizando la clase  _WebAutomator_  y  _UIElement_  simulé interacciones con los distintos elementos de la interfaz gráfica Web. Para ello, primero creé el objeto UIElement utilizando el método   _find_ de  _WebAutomator_ . 

```java
@Test
public void loginTestCase() {
	String testUrl = "https://qalified.com/";
	automator.goTo(testUrl);
	automator.maximizeWindows();
	
	UIElement link_contacto = automator.find(By.linkText("CONTACTO"));
	link_contacto.click();

	UIElement input_nombre = automator.find(By.name("txtName"));
	input_nombre.setText("James Bond");

}

```

### Verificaciones  _(Assertions)_ 

Utilicé los metodos sugeridos por  _TestNG_ , importando el package  _org.testng.Assert.*_   a la clase de pruebas y utilizando los distintos metodos  _assert..._ . 

Como ejemplo...

```java
@Test
public void loginTestCase() {
	String testUrl = "https://qalified.com/";
	automator.goTo(testUrl);
	automator.maximizeWindows();
	
	UIElement link_contacto = automator.find(By.linkText("CONTACTO"));
	link_contacto.click();
	
	UIElement input_nombre = automator.find(By.name("txtName"));
	input_nombre.setText("James Bond");
	
	assertEquals(input_nombre.getValue(), "James Bond", "El texto ingresado no coincide!");

}
```

### Ejecución de la prueba

Agregué las clases donde diseñé los tests al archivo  _testng.xml_ 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite_Demo">
	<parameter name="browser" value="CHROME" />
	<parameter name="max_wait" value="30" />
	<parameter name="close_browser_after_execution" value="false" />
	<test thread-count="5" name="testSuite-sample">
		<classes>
			<class name="test.Omnipro_Test1_NavegarQAlified" />
			<class name="Omnipro_Test2_Excepcion" />
			<class name="Omnipro_Test3_LoginFallido" />
			<class name="Omnipro_Test4_Reservacion" />
			<class name="Omnipro_Test5_NavegarPorLaWeb" />
		</classes>
	</test>
</suite> <!-- Suite -->

```

### Especificación

Relaciono como complemento a la información, la tabla de métodos de la clase **WebAutomator**

| Método        | Descripción           |
| ------------- |---------------|
| public WebDriver `getDriver()`      | Retorna el objeto  _WebDriver_ de Selenium |
| public void `maximizeWindows()`     | Maximiza la ventana del navegador      |
| public void `back()`                | Navega hacia atras en el navegador      |
| public void `forward()`             | Navega hacia adeante en el navegador |
| public void `refresh()`             | Refresca la página del navegador |
| public void `goTo(String url)`      | Navega hacia la url determinada |
| public void `closeBrowser()`        | Cerrar el navegador |
| public void `closeCurrentTab()`     | Cerrar la pestaña de navegación |
| public String `getCurrentUrl()`     | Retorna la URL actual de la pestaña activa |
| public UIElement `find(By by)`      | Retorna el objeto  _UIElement_  que coincide con el selector  _By_ recibido por parámetro |
| public UIElement `findChild(By parent, By child)` | Analiza el objeto _UIElement_ (parent) y retorna el primer objeto  _UIElement_ hijo que coincide con el selector _By_ (child) |
| public UIElement `waitUntilVisible(By by)` | Retorna el objeto  _UIElement_  cuando el mismo sea visible en pantalla |
| public UIElement `waitUntilClickable(By by)` | Retorna el objeto  _UIElement_  cuando el mismo sea cliqueable en pantalla |
| public void `deleteAllCookies()` | Elimina todas las cookies en la sesión del navegador |
| public Set<Cookie> `getAllCookies()` | Retorna todas las cookies del navegador |
| public Cookie `getCookie(String cookie)` | Retorna la cookie cuyo nombre coincida con el recibido por parámetro |
| public void `addCookie(Cookie cookie)` | Agrega una nueva cookie en el navegador |
| public void `takeScreenshot()` | Realiza una captura de pantalla y la almacena en formato .png |

Relaciono como complemento a la información, la tabla de métodos de la clase **UIElement** 

| Método        | Descripción           |
| ------------- |---------------|
| public WebElement `getWebElement()`        | Retorna el objeto  _WebElement_ de Selenium |
| public void `setText(String text)`         | Ingresa el texto recibido por parámetros en el elemento      |
| public void `clear()`                      | Limpia el contenido del elemento                  |
| public void `clearAndSetText(String text)` | Limpia el contenido del elemento e ingresa el texto recibido por parámetro |
| public String `getLink()`                  | Retorna el valor del atributo "href" del elemento web |
| public void `submit()`                     | Confirma el envio de información |
| public void `click()`                      | Simula la acción de clic en el elemento |
| public boolean `isSelected()`              | Retorna verdadero si el elemento web está seleccionado  |
| public boolean `isDisplayed()`             | Retorna verdadero si el elemento web es visible en pantalla  |
| public boolean `isEnabled()`               | Retorna verdadero si el elemento web está habilitado    |
| public String `getText()`                  | Retorna el texto visible de un elemento web |
| public String `getValue()`                 | Retorna el valor de un elemento |
| public UIElement `findElementBy(By by)`    | Retorna un nuevo  _UIElement_  interno al elemento web y que coincida con el selector  _By_ recibido por parámetros |
| public List<UIElement> `findElementsBy(By by)` |  Retorna una lista de  _UIElement_  internos al elemento web y que coincidan con el selector  _By_ recibido por parámetros|
| public void `setTextWithActions(String text)` | Ingresa el texto recibido por parámetros en el elemento utilizando la clase _Actions_  de Selenium |
| public void `selectByValue(String value)` | Selecciona una opcion de la lista basado en el atributo _value_ de la misma  |
| public void `selectByIndex(Integer index)` | Selecciona una opcion de la lista basado en el indice numerico de la misma  |
| public void `selectByVisibleText(String text)` | Selecciona una opcion de la lista basado en el texto visible de la misma  |
| public void `moveToElement()`              | Mueve la UI web hasta hacer visible el elemento en pantalla  |


## Construido con 🛠️

* [Selenium WebDriver](https://www.selenium.dev/) .
* [TestNG](https://testng.org/doc/) .
* [Maven](https://maven.apache.org/) .

## Autor ✒️

Iván Villafañe

## Contacto 📢

**Cel. 3176360616**
**ivan.m.villafane@gmail.com**

## Enlaces

https://github.com/Ivan-Villafane/Omnipro-prueba-practica-LiderQA.git

---
Muchas gracias por permitirme realizar la prueba y espero pronto ser parte del maravilloso equipo Omnipro ❤️
