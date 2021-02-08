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
	private By departure = By.id("gosuggest_inputDest");
	private By fromlocator = By.xpath("//ul[@id='react-autosuggest-1']");
	private By  fromcities=    By.xpath("//ul[@id='react-autosuggest-1']/li");
	private By departurelocator = By.xpath("//ul[@id='react-autosuggest-1']");
	private By  departurecities=    By.xpath("//ul[@id='react-autosuggest-1']/li");
	private By fromdatelocator = By.cssSelector(".DayPicker-Day");
	private By fromdate = By.xpath("//div[@class ='DayPicker-Day']/div");
	private By travellers = By.id("pax_link_common");
	private By Adults = By.id("adultPaxPlus");
	private By children = By.id("childPaxPlus");
	private By infant = By.id("infantPaxPlus");
	private By search = By.xpath("//button[@value='Search']");
	
	
	
	
	public WebElement from()
	{
		return driver.findElement(from);
	}
	
	public By fromlocator() 
	
	{
		return fromlocator;
		
	}
	
	public List<WebElement> fromcities()
	{
		return  driver.findElements(fromcities);
	}
	
	public WebElement departure()
	{
		return driver.findElement(departure);
	}
	
public By departurelocator() 
	
	{
		return departurelocator;
		
	}
	
	public List<WebElement> departurecities()
	{
		return  driver.findElements(departurecities);
	}
	public By fromdatelocator()
	{
		return fromdatelocator;
	}
	
	public List<WebElement> fromdate()
	{
		return driver.findElements(fromdate);
	}
	
    public WebElement travellers()
    {
    	return driver.findElement(travellers);
    }
    public WebElement Adults()
    {
    	return driver.findElement(Adults);
    }
    public WebElement children()
    {
    	return driver.findElement(children);
    }
    public WebElement infant()
    {
    	return driver.findElement(infant);
    }
   public WebElement Search()
   {
	   return driver.findElement(search);
   }
}
