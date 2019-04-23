package challenge2.mmt.tests;

import challenge.mmt.Browser.Driver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestSetup {
 
  @BeforeSuite
  public void beforeSuite() 
  {
	  Driver.initialize();
  }

  @AfterSuite
  public void afterSuite() 
  {
	  Driver.quit();
  }

}
