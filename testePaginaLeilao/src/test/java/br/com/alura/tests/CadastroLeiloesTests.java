package br.com.alura.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.tasks.CadastroLeiloesTasks;
import br.com.alura.tasks.LeiloesTasks;
import br.com.alura.tasks.LoginTasks;
import br.com.alura.tests.base.BaseTests;

public class CadastroLeiloesTests extends BaseTests {
	
	private LeiloesTasks leiloesTasks;
	private LoginTasks loginTasks;
	private CadastroLeiloesTasks cadastroLeiloes;

	@BeforeEach
	public void aguardarCarregamento() throws InterruptedException {
		loginTasks = new LoginTasks(driver);
		leiloesTasks = new LeiloesTasks(driver);
		cadastroLeiloes = new CadastroLeiloesTasks(driver);
		
//		chegar na página de cadastro d eleilão
		loginTasks.clicarBotaoEntrar();
		loginTasks.preencheFormularioDeLogin("fulano", "pass");
		loginTasks.clicarBotaoLogin();
		leiloesTasks.clicarNovoLeilao();
		//
	}
	
	@AfterEach
	public void afterEach() {
		this.loginTasks.fechar();
	}
	
	@Test
	@DisplayName("Cadastra novo leilão")
	public void cadastroNovoLeilao() throws InterruptedException {	
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nomeDoLeilao = "Leilão do dia " + hoje;
		
		cadastroLeiloes.infomarNome(nomeDoLeilao);
		cadastroLeiloes.informarValorInicial("500.00");
		cadastroLeiloes.informarDataAbertura(hoje);
		cadastroLeiloes.validarUsuario("fulano");
		
		cadastroLeiloes.salvarLeilao();
		
		cadastroLeiloes.validarSalvamento(nomeDoLeilao);
	}
	
	@Test
	@DisplayName("Valida valor inicial")
	public void cadastroValorInicial() throws InterruptedException {	
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nomeDoLeilao = "Leilão do dia " + hoje + "333300000000";
		String valorInicial = "2000000.00";
		
		cadastroLeiloes.infomarNome(nomeDoLeilao);
		cadastroLeiloes.informarValorInicial(valorInicial);
		cadastroLeiloes.informarDataAbertura(hoje);
		cadastroLeiloes.validarUsuario("fulano");
		
		cadastroLeiloes.salvarLeilao();
		
		cadastroLeiloes.validaValorInicial(nomeDoLeilao, valorInicial);
	}
	
}
