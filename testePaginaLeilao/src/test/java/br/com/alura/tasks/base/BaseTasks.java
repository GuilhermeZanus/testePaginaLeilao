package br.com.alura.tasks.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTasks {

protected WebDriver driver;
	
	public BaseTasks(WebDriver driver){
		
		this.driver = driver;
		/*
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		
		if(driver != null) {
			this.driver = driver;
		}else {
			this.driver = new ChromeDriver();
			this.driver.get("http://localhost:8080/login");
		}
	*/
    }
	
	public void aguardar(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
	}
}
