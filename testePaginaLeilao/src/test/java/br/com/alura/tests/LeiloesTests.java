package br.com.alura.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.alura.tasks.LeiloesTasks;
import br.com.alura.tasks.LoginTasks;
//import br.com.alura.suporte.SetUpWebDriver;
import br.com.alura.tests.base.BaseTests;

public class LeiloesTests extends BaseTests {

	private LeiloesTasks leiloes;
	private LoginTasks login;

	@BeforeEach
	public void aguardarCarregamento() {
		login = new LoginTasks(jose);
		leiloes = new LeiloesTasks(jose);
	}
	
	@AfterEach
	public void afterEach() {
		this.login.fechar();
	}
	
	@Test
	public void chegarNaPaginaCadastroLeilao() throws InterruptedException {		
		login.clicarBotaoEntrar();
		login.preencheFormularioDeLogin("fulano", "pass");
		login.clicarBotaoLogin();
		leiloes.clicarNovoLeilao();
	}
	//
}

