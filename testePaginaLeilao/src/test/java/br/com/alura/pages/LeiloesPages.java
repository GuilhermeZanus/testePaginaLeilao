package br.com.alura.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.pages.base.BasePages;

public class LeiloesPages extends BasePages {


	public LeiloesPages(WebDriver driver) {
		super(driver);

	}


	public void fechar() {
		driver.quit();		
	}

	public WebElement divContainer() {
		return driver.findElement(By.cssSelector(".container"));
	}
	
	public WebElement botaoNovaoLeilao() {
		return driver.findElement(By.id("novo_leilao_link"));
	}
	
	public WebElement username() {
		
		return driver.findElement(By.id("username"));
	}
	
	public WebElement tabelaLeiloesCadastrados() {
		
		return driver.findElement(By.xpath("//table//tbody"));
	}
	
	public List<WebElement> linhasLeiloesCadastrados() {
		
		return tabelaLeiloesCadastrados().findElements(By.xpath("//tr"));
	}
	
	
	public WebElement linhaLeiloesCadastrados(String indiceLinha) {
		
		return tabelaLeiloesCadastrados().findElement(By.xpath("//tr["+indiceLinha+"]"));
	}
	
	
	public List<WebElement> linhasPorNome(String nomeProduto){
		List<WebElement> lista = linhasLeiloesCadastrados();
		List<WebElement> lista2 = new ArrayList<WebElement>();
		
		for (int i=0; i<lista.size(); i++ ) {
			if(lista.get(i).getText().contains(nomeProduto)) {
				lista2.add(lista.get(i));
			}
		}
		
		return lista2;				
	}
	
	public WebElement colunas(String nomeProduto, int indiceLeilaoSalvo, String indiceColuna) {
		
		return linhasPorNome(nomeProduto).get(indiceLeilaoSalvo).findElement(By.xpath("//td["+indiceColuna+"]"));
	}
	
	
	public WebElement dataDeAberturaDoLeilao(String nomeProduto, int indiceLeilaoSalvo) {
		
		return colunas(nomeProduto, indiceLeilaoSalvo, "1");
	}
	
	
	public WebElement dataDeAberturaDoLeilao(String nomeProduto) {
		
		return dataDeAberturaDoLeilao(nomeProduto, 0);
	}
	 
	
	public WebElement valorInicialDoLeilao(String nomeProduto, int indiceLeilaoSalvo) {
		
		return colunas(nomeProduto, indiceLeilaoSalvo, "2");
	}
	
	public WebElement valorInicialDoLeilao(String nomeProduto) {
		
		return valorInicialDoLeilao(nomeProduto, 0);
	}
	
	public WebElement usuarioDoLeilao(String nomeProduto, int indiceLeilaoSalvo) {
		
		return colunas(nomeProduto, indiceLeilaoSalvo, "3");
	}
	
	
	public WebElement usuarioDoLeilao(String nomeProduto) {
		
		return colunas(nomeProduto, 0, "3");
	}
	
	public WebElement botaoEditarLeilao(String nomeProduto,  int indiceLeilaoSalvo) {
		
		return colunas(nomeProduto, indiceLeilaoSalvo, "4");
	}
	
	public WebElement botaoEditarLeilao(String nomeProduto) {
		
		return colunas(nomeProduto, 0, "4");
	}
	
	
}

