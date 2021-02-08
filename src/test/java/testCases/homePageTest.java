package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectModel.HomePageObjects;
import utilities.BaseClass;
import utilities.UserDefineMethods;
import utilities.webdriverwaits;

public class homePageTest {
	public WebDriver driver;
	public BaseClass base;
	public HomePageObjects hm;
	public webdriverwaits waits;
	public UserDefineMethods methods;

	@BeforeMethod
	public void Initializebrowser() {
		Reporter.log("=====Browser Session Started=====", true);
		base = new BaseClass();
		driver = base.intilisebrowser();

	}

	@Test
	public void homePage() throws InterruptedException {

		driver.get("https://www.goibibo.com/");
		hm = new HomePageObjects(driver);
		hm.from().sendKeys("bengaluru");

		waits = new webdriverwaits(driver);
		waits.waitForElementToAppear(hm.fromlocator());

		List<WebElement> Fromcities = hm.fromcities();
		methods = new UserDefineMethods();
		WebElement from = methods.City(Fromcities, "bengaluru");
		from.click();

		hm.departure().sendKeys("hyd");
		waits.waitForElementToAppear(hm.departurelocator());

		List<WebElement> Departurecities = hm.departurecities();

		WebElement departure = methods.City(Departurecities, "hyderabad");
		departure.click();

		waits.waitForElementToAppear(hm.fromdatelocator());
		List<WebElement> frmdays = hm.fromdate();

		WebElement datefrom = methods.date(frmdays, "16");
		datefrom.click();

		hm.travellers().click();
		// for Two adultPassengers+1 children + 1 infant
		hm.Adults().click();
		hm.children().click();
		hm.infant().click();
		hm.Search().click();

	}

	
	  @AfterMethod 
	  public void closeApplication() 
	  {
	  driver.close();
	  Reporter.log("=====Browser Session End=====", true); }
	 
}
