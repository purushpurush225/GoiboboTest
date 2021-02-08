package pageObjectModel;

import java.util.List;

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
	private By fromlocator = By.xpath("//ul[@id='react-autosuggest-1']");
	private By  fromcities=    By.xpath("//ul[@id='react-autosuggest-1']/li");
	
	public WebElement from()
	{
		return driver.findElement(from);
	}
	
	public By citieslocator() 
	
	{
		return fromlocator;
		
	}
	
	public List<WebElement> cities()
	{
		return  driver.findElements(fromcities);
	}
    
   
}
