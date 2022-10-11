package br.com.alura.suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpWebDriver {

	
//	ESSA CLASSE AINDA ESTÁ APENAS POR GARANTIA MAS SERÁ EXCLUÍDA NA SEQUÊNCIA
	
	public static WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://localhost:8080/login");
		return driver;
	}

}
