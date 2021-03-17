package utilities;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverwaits {
	
	
	 private static final int TIMEOUT = 10; 

	    private static final int POLLING = 100; 

	 

	    protected WebDriver driver; 

	    private WebDriverWait wait; 

	 

	    public  webdriverwaits(WebDriver driver) { 

	        this.driver = driver; 

	        wait = new WebDriverWait(driver, TIMEOUT, POLLING); 

	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this); 

	    } 
    
   
    public void waitForElementVisible(WebElement element) {
    	 wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitForListofWebElementsVisible(List<WebElement> linkElements) 
    {
    wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
    }
    
    public void waitForElementClickable(WebElement element)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void waitForpresenceOfElement(By locator) {
        
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
        }

    public void waitForTextToappear(WebElement element, String text) {
    wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    
    public void waitForFrameandSwitchtoIt(WebElement element) {
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
    
    public void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForTextToDisappear(WebElement element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement( element, text)));
    }
    
    
   
}


