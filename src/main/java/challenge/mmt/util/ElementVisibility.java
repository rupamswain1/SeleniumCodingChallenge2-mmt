package challenge.mmt.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import challenge.mmt.Browser.Driver;

public class ElementVisibility {

	public static boolean isVisble(WebElement element)
	{
		boolean flag=false;
		Driver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
		Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return flag;
		
	}
	
}
