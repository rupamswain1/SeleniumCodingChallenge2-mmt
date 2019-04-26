package challenge.mmt.Browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import challenge.mmt.Report.LogStatus;
import challenge2.mmt.Listner.EventHandler;
import challenge2.mmt.ReadProperty.ReadPropertyFile;


public class Driver extends ReadPropertyFile
{
	public static WebDriver driver=null;
	
	//Private constructor to limit initialization, Initializes browser based on inputs from properties file
	private Driver()
	{
		String browser=ReadPropertyFile.get("Browser");
		String headless=ReadPropertyFile.get("HeadlessMode");
		String imageDisable=ReadPropertyFile.get("DisableImage");
		if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME"))
		{
			try{
				
				System.setProperty("webdriver.chrome.driver",OsPath.getPath(browser));
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--incognito");
				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(options);
				}
				/*if(headless.equalsIgnoreCase("yes"))
				{
					new HeadlessMode().headless(options);
				}*/
				DesiredCapabilities capabilites=DesiredCapabilities.chrome();
				capabilites.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(options);
				
				LogStatus.pass("Chrome drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
								
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (browser.equalsIgnoreCase("FF")|| browser.toUpperCase().contains("FIRE")) 
		{
			try
			{
				
				System.setProperty("webdriver.gecko.driver",OsPath.getPath(browser));
				FirefoxOptions FFoptions=new FirefoxOptions();
				if(imageDisable.equalsIgnoreCase("yes"))
				{
					new DisableImage().disableImg(FFoptions);
				}
				if(headless.equalsIgnoreCase("yes"))
				{
					new HeadlessMode().headless(FFoptions);
				}
				
				driver=new FirefoxDriver(FFoptions);
				
				
				LogStatus.pass("FF drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				LogStatus.fail(e);
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		EventHandlerInit();
		driver.get(ReadPropertyFile.get("url"));
		driver.manage().deleteAllCookies();
	}
	
	//Initializes browser instance
	public static void initialize()
	{
		new Driver();
	}
	//quits browser
	public static void quit()
	{
		driver.quit();
	}
	//initializes WebDriver EventListner
	public void EventHandlerInit()
	{
		EventFiringWebDriver eventHandle=new EventFiringWebDriver(driver);
		EventHandler handler=new EventHandler();
		eventHandle.register(handler);
		driver=eventHandle;
	}
	
	
}
