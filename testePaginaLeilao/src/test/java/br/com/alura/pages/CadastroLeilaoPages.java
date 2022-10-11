package br.com.alura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.pages.base.BasePages;

public class CadastroLeilaoPages extends BasePages{

	public CadastroLeilaoPages(WebDriver driver) {
		super(driver);		
	}
	
	public void fechar() {
		driver.quit();	
		System.out.println("teste de integração ceclipse - github");
	}
	
	public WebElement divContainer() {
		return driver.findElement(By.cssSelector(".container"));
	}
	
	public WebElement nome() {
		return driver.findElement(By.id("nome"));
	}

	public WebElement valor() {		
		return driver.findElement(By.id("valorInicial"));
	}

	public WebElement dataAbertura() {
		return driver.findElement(By.id("dataAbertura"));
	}
	
	public WebElement usuarioCadastroLeilao() {
		return driver.findElement(By.xpath("//label[@for='usuario']/following-sibling::input"));
	}

	public WebElement botaoSalvar() {
		return driver.findElement(By.id("button-submit"));		
	}
	

}
