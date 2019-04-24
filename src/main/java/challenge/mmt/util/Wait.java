package challenge.mmt.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import challenge.mmt.Browser.Driver;


public class Wait {

	//waits for element to be clickable
	public static void toBeclickable(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(Driver.driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	//waits for proper data to be populated
	public static void toBeclickable2(WebElement element,String data)
	{
		while(!element.getAttribute("innerText").toLowerCase().contains(data.toLowerCase()))
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
