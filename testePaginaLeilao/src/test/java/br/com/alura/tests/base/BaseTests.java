package br.com.alura.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

protected WebDriver driver;
	
	public BaseTests(){
//		this.jose = jose;
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");
		driver.manage().window().maximize();
    }
}
//