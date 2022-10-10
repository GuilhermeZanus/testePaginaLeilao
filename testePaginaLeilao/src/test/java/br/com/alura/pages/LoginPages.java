package br.com.alura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.alura.pages.base.BasePages;

public class LoginPages extends BasePages{

	public LoginPages(WebDriver driver) {
		super(driver);
		
	}

/*
	private WebDriver driver;


	
	public LoginPages(WebDriver driver) {
		this.driver = driver;
	}
*/

	public void fechar() {
		driver.quit();		
	}

	/*
//	MÉTODOS ANTIGOS
	public void preencheFormularioDeLogin(String username, String password) {
//		basePages.findElement(By.id("username")).sendKeys(username);
//		basePages.findElement(By.id("password")).sendKeys(password);		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);		
	}

	public void efetuaLogin() {
		//pegou o id de todo o formulário e submeteu, ao invés de clicar no botão
		driver.findElement(By.id("login-form")).submit(); 
	}

	public void validaLoginEfetuado(String username) {
		Assert.assertFalse(driver.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertEquals(username, driver.findElement(By.id("usuario-logado")).getText());		
	}

	public void validaLoginInvalido() {
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assert.assertTrue(driver.getPageSource().contains("Usuário e senha inválidos."));
	}

	public void acessaPaginaLances() {
		driver.navigate().to("http://localhost:8080/leiloes/2");		
	}

	public void validaNaoAcessoNaPaginaRestrita() {
//		verifica se ao invés de entrar na página restrita ele foi direcionado para a página de login
		Assert.assertTrue(driver.getCurrentUrl().equals(URL_LOGIN));
//		verifica se a página que está sendo acessada NÃO contem a frase "Dados do Leilão", que seria a frase da página que se tentou acessar
		Assert.assertFalse(driver.getPageSource().contains("Dados do Leilão"));
		}
*/
	
//	NOVOS MÉTODOS
	
	public WebElement entrar() {
		return driver.findElement(By.cssSelector(".text-light"));
	}
	
	public WebElement username() {
		
		return driver.findElement(By.id("username"));
	}

	public WebElement password() {
		
		return driver.findElement(By.id("password"));
	}

	public WebElement formLogin() {
		
		return driver.findElement(By.id("login-form"));
	}
	
	public WebElement botaoLogin() {
		return formLogin().findElement(By.cssSelector(".btn"));
	}

	public String URLAtual() {
		
		return driver.getCurrentUrl();
	}

	public WebElement usuarioLogado() {
		
		return driver.findElement(By.id("usuario-logado"));
	}

	public String codigoFonte() {
		
		return driver.getPageSource();
	}


	public void alterarURL(String endereço) {
		driver.navigate().to(endereço);
		
	}
	
}

