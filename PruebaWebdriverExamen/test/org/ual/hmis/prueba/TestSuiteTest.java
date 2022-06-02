package org.ual.hmis.prueba;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestSuiteTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
//		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); // HAY QUE COMENTAR ESTO EN JENKINS
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void t1testCreacionTareaCasoCorrecto() {
		// Test name: TestCreacionTarea(CasoCorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | setWindowSize | 1536x824 |
		driver.manage().window().setSize(new Dimension(1536, 824));
		// 3 | click | linkText=Create New |
		driver.findElement(By.linkText("Create New")).click();
		// 4 | click | id=Description |
		driver.findElement(By.id("Description")).click();
		// 5 | type | id=Description | Tarea1
		driver.findElement(By.id("Description")).sendKeys("Tarea1");
		// 6 | click | id=CreatedDate |
		driver.findElement(By.id("CreatedDate")).click();
		// 7 | type | id=CreatedDate | 2022-06-11
		driver.findElement(By.id("CreatedDate")).sendKeys("2022-06-11");
		// 8 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		// 9 | assertElementPresent | xpath=//td[normalize-space(text()) = 'Tarea1'] |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = \'Tarea1\']"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void t2testCreacionTareaCasoIncorrecto() {
		// Test name: TestCreacionTarea(CasoIncorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | setWindowSize | 1536x824 |
		driver.manage().window().setSize(new Dimension(1536, 824));
		// 3 | click | linkText=Create New |
		driver.findElement(By.linkText("Create New")).click();
		// 4 | click | id=Description |
		driver.findElement(By.id("Description")).click();
		// 5 | type | id=Description | Lista2
		driver.findElement(By.id("Description")).sendKeys("Lista2");
		// 6 | click | linkText=Back to List |
		driver.findElement(By.linkText("Back to List")).click();
		// 7 | assertElementNotPresent | xpath=//td[normalize-space(text()) = 'Tarea3']
		// |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea3']"));
			assert (elements.size() == 0);
		}
	}

	@Test
	public void t3testListadoTareaCasoCorrecto() {
		// Test name: TestListadoTarea(CasoCorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | assertElementPresent | xpath=//td[normalize-space(text()) = 'Tarea1'] |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea1']"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void t4testListadoTareaCasoIncorrecto() {
		// Test name: TestListadoTarea(CasoIncorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | assertElementNotPresent | xpath=//td[normalize-space(text()) = 'Tarea3']
		// |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea3']"));
			assert (elements.size() == 0);
		}
	}

	@Test
	public void t5testModificarTareaCasoCorrecto() {
		// Test name: TestModificarTarea(CasoCorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | setWindowSize | 1536x824 |
		driver.manage().window().setSize(new Dimension(1536, 824));
		// 3 | click | linkText=Edit |
		driver.findElement(By.linkText("Edit")).click();
		// 4 | click | id=Description | 
	    driver.findElement(By.id("Description")).click();
		// 5 | type | id=Description | Tarea2
		driver.findElement(By.id("Description")).sendKeys("Tarea2");
		// 6 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		// 7 | assertElementPresent | xpath=//td[normalize-space(text()) = 'Tarea2'] |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea1Tarea2']"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void t6testModificarTareaCasoIncorrecto() {
		// Test name: TestModificarTarea(CasoIncorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | setWindowSize | 1536x824 |
		driver.manage().window().setSize(new Dimension(1536, 824));
		// 3 | click | linkText=Edit |
		driver.findElement(By.linkText("Edit")).click();
		// 4 | click | linkText=Back to List |
		driver.findElement(By.linkText("Back to List")).click();
		// 5 | assertElementNotPresent | xpath=//td[normalize-space(text()) = 'Tarea1']
		// |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea1']"));
			assert (elements.size() == 0);
		}
	}

	@Test
	public void t7testEliminacionTareaCasoIncorrecto() {
		// Test name: TestEliminacionTarea(CasoIncorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | storeText | css=td:nth-child(1) | textoNombre
		vars.put("textoNombre", driver.findElement(By.cssSelector("td:nth-child(1)")).getText());
		// 3 | click | linkText=Delete |
		driver.findElement(By.linkText("Delete")).click();
		// 4 | click | linkText=Back to List |
		driver.findElement(By.linkText("Back to List")).click();
		// 5 | assertElementPresent | xpath=//td[normalize-space(text()) = 'Tarea2'] |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea2']"));
			assert (elements.size() == 0);
		}
	}

	@Test
	public void t8testEliminacionTareaCasoCorrecto() {
		// Test name: TestEliminacionTarea(CasoCorrecto)
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://coresqlfernandezcamacho.azurewebsites.net/");
		// 2 | assertElementPresent | xpath=//td[normalize-space(text()) = 'Tarea2'] |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea1Tarea2']"));
			assert (elements.size() > 0);
		}
		// 3 | click | linkText=Delete |
		driver.findElement(By.linkText("Delete")).click();
		// 4 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		// 5 | assertElementNotPresent | xpath=//td[normalize-space(text()) = 'Tarea2']
		// |
		{
			List<WebElement> elements = driver.findElements(By.xpath("//td[normalize-space(text()) = 'Tarea2']"));
			assert (elements.size() == 0);
		}
	}
}
