package challenge.mmt.Browser;

public class OsPath {
	
	
	public static String getPath(String browser) 
	{
		String OS=System.getProperty("os.name");
		String driverPath=null;
		if(OS.toUpperCase().contains("WINDOWS"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//src//main//resources//chromedriver.exe";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//src//main//resources//geckodriver.exe";
				
			}
		}
		else if(OS.toUpperCase().contains("MAC"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//src//main//resources//chromedriver";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//src//main//resources//geckodriver";
			}
		}
		return driverPath;
	}

	
}
