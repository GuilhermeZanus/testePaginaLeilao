package br.com.alura.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.pages.base.BasePages;

public class LeiloesPages extends BasePages {

	/*
	private WebDriver driver;
	
	public LeiloesPages(WebDriver driver) {
		this.driver = driver;
	}
*/

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
	
	public List<LinhaLeilaoPages> buscaLinhaPorValor(String nomeProduto){
		
		
		
		List<LinhaLeilaoPages> linhas = linhasLeiloesCadastrados()
				.stream()
				.filter(linhasLeiloesCadastrados -> linhasLeiloesCadastrados.findElements(By.cssSelector("td"))
						.stream()
						.anyMatch(td -> td.getText().equals(nomeProduto)))
				.map(el -> new LinhaLeilaoPages(driver, el))
				.collect(Collectors.toList());
		
		for (int i =0; i<linhas.size(); i++) {
			System.out.println(linhas.get(i).colunas().get(0).getText());			
		}		
			return linhas;	
		
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
	
	
	
	
	

	
	
}

