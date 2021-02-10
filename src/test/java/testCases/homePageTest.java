package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

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

	@Test(groups = { "FuntionalTest" })
	public void homePage() throws InterruptedException {

		driver.get("https://www.goibibo.com/");
		hm = new HomePageObjects(driver);
		waits = new webdriverwaits(driver);

		hm.from().sendKeys("Chennai");

		List<WebElement> Fromcities = hm.fromcities();

		waits.waitForListofWebElementsVisible(Fromcities);

		methods = new UserDefineMethods();
		WebElement from = methods.City(Fromcities, "chennai");
		from.click();

		hm.departure().click();
		hm.departure().sendKeys("hyder");
		

		List<WebElement> Departurecities = hm.departurecities();
		
		waits.waitForListofWebElementsVisible(Departurecities);
		WebElement departurecity = methods.City(Departurecities, "hyderabad");
		departurecity.click();
        


		waits.waitForElementVisible(hm.fromday());

		List<WebElement> frmdays = hm.fromdate();
		WebElement datefrom = methods.date(frmdays, "16");
		datefrom.click();

		hm.travellers().click();
		// for Two adultPassengers+1 children + 1 infant
		hm.Adults().click();
		hm.children().click();
		hm.infant().click();
		hm.Search().click();
		System.out.println(driver.getTitle());

	}

	
	@Test(groups = { "UITest" }) 
	public void uitest() {
	  driver.get("https://www.goibibo.com/"); 
	  String color = driver.findElement(By.xpath("//a[text()='Explore All Offers']")).getCssValue("color"); 
	  String hexcolor = Color.fromString(color).asHex(); // convertedIntoHexFormat 
	  String expected = "#ffffff"; assertEquals(expected, hexcolor);
	  
	  }
	
	
	
	@Test(groups= {"FuntionalTest"},priority =1)
	public void footerlinks() {
		String url = "";
		String homePage ="https://www.goibibo.com/";
        HttpURLConnection huc = null;
        int respCode = 200;
		driver.get(homePage);
		List<WebElement> footerlinks =driver.findElements(By.xpath("//div[@id='footer']/div[2]/div/ul/li/a"));
		
        Iterator<WebElement>  it = footerlinks.iterator();
        
         while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
             System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		
	}
	
	
	
	  
	  @AfterMethod public void closeApplication() { driver.close();
	  Reporter.log("=====Browser Session End=====", true); }
	 

}
