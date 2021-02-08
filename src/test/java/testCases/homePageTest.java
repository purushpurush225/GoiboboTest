package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pageObjectModel.HomePageObjects;
import utilities.BaseClass;
import utilities.webdriverwaits;

public class homePageTest {
	public WebDriver driver;
	public BaseClass base;
	public HomePageObjects hm;
	public webdriverwaits waits;

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
		Actions a = new Actions(driver);
		a.moveToElement(hm.from()).click().sendKeys("Tirupati").perform();

		waits = new webdriverwaits(driver);
		waits.waitForElementToAppear(hm.citieslocator());

		List<WebElement> cities = hm.cities();

		for (WebElement eachcity : cities) {

			String city = eachcity.getText().split(",")[0].trim();
			
			if (city.equalsIgnoreCase("Tirupati")) 
			{
			    eachcity.click();
				break;
			}

		}

	}

	@AfterSuite
	public void closeApplication() {
		driver.close();

		Reporter.log("=====Browser Session End=====", true);
	}

}
