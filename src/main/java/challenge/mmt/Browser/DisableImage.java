package challenge.mmt.Browser;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DisableImage 
{
	public void disableImg(ChromeOptions options)
	{
		HashMap<String, Object> images=new HashMap<String, Object>();
		images.put("images", 2);
		HashMap<String, Object> pref=new HashMap<String, Object>();
		pref.put("profile.default_content_setting_values", images);
		options.setExperimentalOption("prefs", pref);
	}
	public void disableImg(FirefoxOptions options)
	{
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
	}
}
