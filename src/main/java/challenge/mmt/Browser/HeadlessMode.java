package challenge.mmt.Browser;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessMode 
{
	public void headless(ChromeOptions options)
	{
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
	}
	public void headless(FirefoxOptions options)
	{
		FirefoxBinary firefoxBinary=new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		options.setBinary(firefoxBinary);
	}
}
