package challenge.mmt.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import challenge.mmt.Browser.Driver;

public class PageScroll {

	public static void toBottomOfPage()
	{
		try {
		    long Height =Long.parseLong(((JavascriptExecutor) Driver.driver).executeScript("return document.body.scrollHeight").toString());

		    while (true) {
		        ((JavascriptExecutor) Driver.driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        //Thread.sleep(1000);

		        long newHeight = Long.parseLong(((JavascriptExecutor) Driver.driver).executeScript("return document.body.scrollHeight").toString());
		        if (newHeight == Height) {
		            break;
		        }
		        Height = newHeight;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static void toUP()
	{
		    
		     ((JavascriptExecutor) Driver.driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
	
	}
	
	public static void toElement(WebElement element)
	{
		((JavascriptExecutor) Driver.driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
