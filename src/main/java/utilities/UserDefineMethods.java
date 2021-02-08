package utilities;

import java.util.List;
import org.openqa.selenium.WebElement;

public class UserDefineMethods {
	
	public WebElement City(List<WebElement> cities,String cityname)
	{
		
	for (WebElement eachcity : cities) {

		String city = eachcity.getText().split(",")[0].trim();
		
		if (city.equalsIgnoreCase(cityname)) 
		{
		    return eachcity;
		   
		 }
	
	}
	System.out.println("city is not visible");
	return null;
	
}
	
	public WebElement date(List<WebElement> days,String date)
	{
		
	for (WebElement day : days) {

		String getdate = day.getText().trim().toString();
		
		if (getdate.equalsIgnoreCase(date)) 
		{
		    return day;
		   
		 }
	
	}
	System.out.println("date is not avilable");
	return null;
	
}
	
	
	
	
	
	
	}
	

	