package br.com.alura.tasks;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.alura.pages.LeiloesPages;
import br.com.alura.pages.LoginPages;
import br.com.alura.tasks.base.BaseTasks;

public class LoginTasks extends BaseTasks {

	private static final String URL_LOGIN = "http://localhost:8080/login";
//	private WebDriver driver;

	private LoginPages loginPages;
	private LeiloesPages leiloesPages;
	private WebDriverWait wait = new WebDriverWait(driver, 10);
//	private BasePages basePages;
	
	public LoginTasks(WebDriver driver) {	
		super(driver);
		
		this.loginPages = new LoginPages(driver);
		this.leiloesPages = new LeiloesPages(driver)
;//		basePages = new BasePages();
		
	}

	public void fechar() {
		loginPages.fechar();
	}

	public void clicarBotaoEntrar() {
		loginPages.entrar().click();
	}
	
	public void preencheFormularioDeLogin(String username, String password) {
		
		loginPages.username().sendKeys(username);
		loginPages.password().sendKeys(password);
	}

	public void clicarBotaoLogin() throws InterruptedException {

		loginPages.botaoLogin().click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".container")));
				
//		leiloesPages.divContainer().wait(5000);
		
		
		
	}

	public void validaLoginEfetuado(String username) {
//		Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
//		Assert.assertEquals(username, browser.findElement(By.id("usuario-logado")).getText());	
		
		Assert.assertFalse(loginPages.URLAtual().equals(URL_LOGIN));
		Assert.assertEquals(username, loginPages.usuarioLogado().getText());	
		
	}

	public void validaLoginInvalido() {
		Assert.assertTrue(loginPages.URLAtual().equals("http://localhost:8080/login?error"));
//		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		Assert.assertTrue(loginPages.codigoFonte().contains("Usuário e senha inválidos."));
		
	}

	public void acessaPagina(String endereço) {
		loginPages.alterarURL(endereço);
//		driver.navigate().to(endereço);		
	}
	
//	public void acessaPaginaLances() {
//		browser.navigate().to("http://localhost:8080/leiloes/2");		
//	}

	public void validaNaoAcessoNaPaginaRestrita() {
//		verifica se ao invés de entrar na página restrita ele foi direcionado para a página de login
		Assert.assertTrue(loginPages.URLAtual().equals(URL_LOGIN));
//		verifica se a página que está sendo acessada NÃO contem a frase "Dados do Leilão", que seria a frase da página que se tentou acessar
		Assert.assertFalse(loginPages.codigoFonte().contains("Dados do Leilão"));
		}
}
