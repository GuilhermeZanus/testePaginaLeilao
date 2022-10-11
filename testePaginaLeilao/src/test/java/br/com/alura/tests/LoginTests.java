package br.com.alura.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.tasks.LeiloesTasks;
import br.com.alura.tasks.LoginTasks;
import br.com.alura.tests.base.BaseTests;


public class LoginTests extends BaseTests {

	private LoginTasks login;	

	@BeforeEach
	public void aguardarCarregamento() {
		this.login = new LoginTasks(driver);		
	}
	
	@AfterEach
	public void afterEach() {		
		this.login.fechar();
	}
	
	@Test
	@DisplayName("Efetua login com dados válidos")
	public void deveriaEfetuarLoginComDadosValidos() throws InterruptedException {	
		
		String nome = "fulano";

		login.preencheFormularioDeLogin(nome, "pass");
		login.clicarBotaoLogin();					
		login.validaLoginEfetuado(nome);
	}
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos() throws InterruptedException {
		
		login.preencheFormularioDeLogin("invalido", "123");
		login.clicarBotaoLogin();		
		
		login.validaLoginInvalido();
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {		
		login.acessaPagina("http://localhost:8080/leiloes/2");
		login.validaNaoAcessoNaPaginaRestrita();
	}
}

