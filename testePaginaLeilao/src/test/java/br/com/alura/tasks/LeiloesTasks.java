package br.com.alura.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.alura.pages.LeiloesPages;
import br.com.alura.pages.LoginPages;
import br.com.alura.tasks.base.BaseTasks;

public class LeiloesTasks extends BaseTasks {

	private static final String URL_LOGIN = "http://localhost:8080/login";
//	private WebDriver driver;
	private LoginPages loginPages;
	private LeiloesPages leiloesPages;
	private WebDriverWait wait = new WebDriverWait(driver, 10);
//	private BasePages basePages;
	
	public LeiloesTasks(WebDriver driver) {	
		super(driver);
		loginPages = new LoginPages(driver);
		leiloesPages = new LeiloesPages(driver);
//		basePages = new BasePages();
		
	}

	public void fechar() {
		loginPages.fechar();
	}
	
	public void clicarNovoLeilao() {
		leiloesPages.botaoNovaoLeilao().click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".container")));
	}

	
}
