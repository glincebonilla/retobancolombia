package com.bancolombia.gestiontarjetas;

import com.gestor.excel.DataRequest;
import com.gestor.excel.ExcelWrite;
import com.gestor.excel.ExcelRead;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditCardPage extends BasePage {

	public CreditCardPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	/*
	 * Page Variables
	 */
	String baseURL = "https://www.grupobancolombia.com/wps/portal/personas";

	/*
	 * Web Elements
	 */
	String opcionProductosServicicios = "a[href*='productosPersonas']";
	String opcionTarjetasCredito = "Tarjetas Crédito";
	String tarjetaAmericanExpress = "card_0";
	String infoAmericanExpress = "//*[@id=\"card_0\"]/div[3]/ul";
	String tarjetaMasterBlack = "card_1";
	String infoMasterBlack = "//*[@id=\"card_0\"]/div[3]/ul";
	String botonsolicitarAmericanExpress = "//*[@id=\"card_0\"]/div[4]/a";
	String frameDatosPersona = "Demos";
	String inputNombres = "nombresReq";
	String inputApellidos = "apellidosReq";
	String inputTipoDoc = "typedocreq";
	String inputNumeroDocumento = "numeroDocumento";
	String inputFechaNacimiento = "fechaNacimientoReq";
	String inputIngresosMensuales = "ingresos-mensuales";
	String iputCiudadDepartamento = "reqCiuidadDpto_value";

	/*
	 * Page Methods
	 */
	public void goToTarjetasCredito() {
		driver.get(baseURL);
		click(By.cssSelector(opcionProductosServicicios));
		click(By.linkText(opcionTarjetasCredito));
	}

	public String getTitleAmerican() {
		String titleAmerican = driver.findElement(By.id("card_0")).findElement(By.tagName("h2")).getText();
		return titleAmerican;
	}

	public String getTitleMasterBlack() {
		String titleBlack = driver.findElement(By.id("card_1")).findElement(By.tagName("h2")).getText();
		return titleBlack;
	}

	public String getProductAmericanInfo() {
		String productAmericaInfo = driver.findElement(By.id("card_0"))
				.findElement(By.xpath("//*[@id=\"card_0\"]/div[3]/ul")).getText();

		return productAmericaInfo;
	}

	public String getProductBlackInfo() {
		String productBlackInfo = driver.findElement(By.id("card_1"))
				.findElement(By.xpath("//*[@id=\"card_0\"]/div[3]/ul")).getText();
		return productBlackInfo;
	}

	public void applyFormAmerican() {
		driver.findElement(By.id(tarjetaAmericanExpress)).findElement(By.xpath(botonsolicitarAmericanExpress)).click();
	}

	public void saveInfoCardsExcelFile() throws IOException {
		String titleAmerican = getTitleAmerican();
		String productMasterInfo = getProductAmericanInfo();
		String titleBlack = getTitleMasterBlack();
		String productBlackInfo = getProductBlackInfo();
		ExcelWrite.createExcelFile(System.getProperty("user.dir") + "\\ExcelData\\infotarjetas.xlsx",
				(titleAmerican + "\n" + productMasterInfo), (titleBlack + "\n" + productBlackInfo));
	}

	public void sendDataFormToGetCard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement frameDatos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Demos")));

		driver.switchTo().frame(frameDatos);

		DataRequest objDatos = ExcelRead
				.ReadExcelFile(System.getProperty("user.dir") + "\\ExcelData\\TestDataSolicitudTarjeta1.xlsx");

		driver.findElement(By.id("nombresReq")).sendKeys(objDatos.getNombres());
		driver.findElement(By.id("apellidosReq")).sendKeys(objDatos.getApellidos());

		Select drpTipoDocumento = new Select(driver.findElement(By.id("typedocreq")));
		drpTipoDocumento.selectByValue(objDatos.getTipoDcocumento());

		driver.findElement(By.id("numeroDocumento")).sendKeys(objDatos.getNumeroDocumento());
		driver.findElement(By.id("fechaNacimientoReq")).sendKeys(objDatos.getFechaNacimiento());
		driver.findElement(By.id("ingresos-mensuales")).sendKeys(objDatos.getIngresos());

		WebElement ciudadDepartamento = driver.findElement(By.id("reqCiuidadDpto_value"));
		String city = objDatos.getCiudadDepartamento();

		for (int i = 0; i < city.length(); i++) {

			ciudadDepartamento.sendKeys(city.substring(i, i + 1));
			Thread.sleep(500);
		}

		ciudadDepartamento.sendKeys(Keys.TAB);

		WebElement btnContinuar = driver.findElements(By.tagName("button")).get(2); // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Continuar']")));
		driver.findElement(By.id("fechaNacimientoReq")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("fechaNacimientoReq")).sendKeys(Keys.TAB);
		btnContinuar.getText();

		driver.switchTo().defaultContent();
	}

}
