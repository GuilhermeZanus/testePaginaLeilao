package br.com.alura.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

protected WebDriver jose;
	
	public BaseTests(){
//		this.jose = jose;
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		jose = new ChromeDriver();
		jose.get("http://localhost:8080/login");
		jose.manage().window().maximize();
    }
}
