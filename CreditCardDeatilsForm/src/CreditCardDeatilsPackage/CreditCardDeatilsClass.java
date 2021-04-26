package CreditCardDeatilsPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreditCardDeatilsClass {

	WebDriver driver = new PhantomJSDriver();
	   String driverPath = "C:\\geckodriver.exe";
	   File file = new File("D:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");	
	   public String baseUrl = "https://codesandbox.io/s/9y8vkrrx9o";
	   
	  @BeforeMethod
	  public void launchBrowser() 
	  {
		  System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
	      driver.get("https://codesandbox.io/s/9y8vkrrx9o");
	  }
	  @Test
	  public void CreditValidations()
	  {
		  //CardNumber Validation
		  WebElement cardNumber = driver.findElement(By.name("number"));
		  cardNumber.sendKeys("378282246310005");
		  
		  //Name Validation
		  WebElement name = driver.findElement(By.name("name"));
		  name.sendKeys("John Caster");
		  //Card Type Validation
		  WebElement cardType = driver.findElement(By.name("type"));
		  name.sendKeys("American Express");	  
		  
		  //Expire date Validation
		  WebElement expireDate = driver.findElement(By.name("expiry"));
		  expireDate.sendKeys("03/21");
		  
		  //CVV Validation
		  WebElement CVV= driver.findElement(By.name("cvc"));
		  CVV.sendKeys("1234");
		  
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[5]/button[1]")).click();    
	  }
	  @AfterMethod
	  public void exitBrowser() 
	  {
		  driver.close();
	  }
	}
