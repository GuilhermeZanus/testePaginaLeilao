package br.com.alura.tasks;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.pages.CadastroLeilaoPages;
import br.com.alura.pages.LeiloesPages;
import br.com.alura.tasks.base.BaseTasks;

public class CadastroLeiloesTasks extends BaseTasks {
	
	private CadastroLeilaoPages cadastroLeiloesPages;
	private LeiloesPages leiloes;

	public CadastroLeiloesTasks(WebDriver driver) {
		super(driver);		
		cadastroLeiloesPages = new CadastroLeilaoPages(driver);
		leiloes = new LeiloesPages(driver);
	}

	public void infomarNome(String nome) {
		cadastroLeiloesPages.nome().sendKeys(nome);		
	}

	public void informarValorInicial(String valor) {
		cadastroLeiloesPages.valor().sendKeys(valor);		
	}

	public void informarDataAbertura(String hoje) {
		cadastroLeiloesPages.dataAbertura().sendKeys(hoje);		
	}
	
	public void validarUsuario(String usuario) {
				
		Assertions.assertEquals(usuario, cadastroLeiloesPages.usuarioCadastroLeilao().getAttribute("value"));		
	}

	public void salvarLeilao() {
		cadastroLeiloesPages.botaoSalvar().click();	
		aguardar(".container");
	}

	public void validarSalvamento(String nome) {
		int tamanhoLista = leiloes.linhasPorNome(nome).size();
		Assertions.assertTrue(tamanhoLista>=1, "Leilão não foi salvo");		
	}		

}

