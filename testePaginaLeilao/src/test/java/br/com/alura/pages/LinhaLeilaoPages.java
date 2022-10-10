package br.com.alura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.pages.base.BasePages;

public class LinhaLeilaoPages extends BasePages{

	public LinhaLeilaoPages(WebDriver driver, WebElement el) {
		super(driver);		
	}
	
	public List<WebElement> colunas() {
		return driver.findElements(By.tagName("td"));
	}
}