package com.bancolombia.gestiontarjetas;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Utils\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();

	}

	@AfterClass
	public static void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
