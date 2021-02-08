package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects 
{
	public WebDriver driver;
	
	public HomePageObjects(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	private By from = By.id("gosuggest_inputSrc");
	
	
	public WebElement from()
	{
		return driver.findElement(from);
	}
	
	
	
    
   
}
