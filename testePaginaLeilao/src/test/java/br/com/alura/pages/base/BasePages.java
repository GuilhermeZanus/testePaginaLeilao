package br.com.alura.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePages {
	
	protected WebDriver driver;
	
	public BasePages(WebDriver driver){

		this.driver = driver;
		/*
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		if(driver != null) {
			this.driver = driver;
		}else {
//			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			this.driver = new ChromeDriver();
			this.driver.get("http://localhost:8080/login");
		}
	*/	
    }
	
	

}


