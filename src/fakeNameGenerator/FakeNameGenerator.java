package fakeNameGenerator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Usuario.Usuario;

public class FakeNameGenerator {
	
	public FakeNameGenerator(){
		
	}
	
	public Usuario irAFakeNameGenerator() {
		
	   //Instanciar un objeto WebDriver
		WebDriver driver;
		
		//Declaro Variables
		String baseURL = "https://www.fakenamegenerator.com/";
		String actualResult="";
		String espectedResoult = "Generate a Random Name - Fake Name Generator";
		
		//Indicar la localización del arhivo chromedirver.exe en la propiedad webdriver.chromedriver
		//System.getProperty("usr.dir") = C:\..\..\..SeleniumBasico
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		
		//Abrir el navegador Chrome
		driver = new ChromeDriver();
		
		//Navegar a la página
		driver.get(baseURL);
		
		//Extaer el títutlo de la página web
		actualResult = driver.getTitle();
		
		//Imprimir el resultado usando el operador ternario
		//System.out.println(actualResult.contentEquals(espectedResoult)?"Prueba Pasada, el títutlo es: " + actualResult : "Prueba fallada, el títutlo es: " + actualResult );
	
		
		String firstName = driver.findElement(By.xpath("//*[@id=\"details\"]/div[2]/div[2]/div/div[1]/h3")).getText(); 
		String lastName = driver.findElement(By.xpath("//*[@id=\"details\"]/div[2]/div[2]/div/div[2]/dl[1]/dd")).getText();
		String userName = driver.findElement(By.xpath("//*[@id=\"details\"]/div[2]/div[2]/div/div[2]/dl[10]/dd")).getText()+lastName;
		String password = driver.findElement(By.xpath("//*[@id=\"details\"]/div[2]/div[2]/div/div[2]/dl[11]/dd")).getText()+lastName;
		
		
		
		driver.close();
		
		return (new Usuario (firstName,lastName,userName,password));
			
		
	}
	
}
