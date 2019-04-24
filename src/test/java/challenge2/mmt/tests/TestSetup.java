package challenge2.mmt.tests;

import challenge.mmt.Browser.Driver;
import challenge.mmt.Report.ExtentReport;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.AfterSuite;

public class TestSetup {
 //Initializes browser and reports
  @BeforeSuite
  public void beforeSuite() 
  {
	  ExtentReport.initialize();
	  
	  ExtentReport.logger= ExtentReport.report.startTest("Selenium coding challenge 2");
	  Driver.initialize();
	  

  }
//closed browser and report object
  @AfterSuite
  public void afterSuite() 
  {
	  Driver.quit();
	  ExtentReport.report.flush();
	  
  }

}
