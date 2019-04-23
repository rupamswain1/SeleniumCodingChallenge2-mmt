package challenge2.mmt.tests;

import org.testng.annotations.Test;

import challenge2.mmt.WebPages.FlightResultPage;
import challenge2.mmt.WebPages.HomePage;

public class FlightCounts {
	
	public static FlightResultPage pageObj=null;
	int[] counts;
  @Test(priority=1)
  public void NoFilterFlightCounts() 
  {
	  pageObj=HomePage.obj;
	  counts=pageObj.NoFilterFlightCount();
	  System.out.println("*****Flight Count when No checkbox are selected*****");
	  System.out.println("Depature Flght count:"+counts[0]+"\nReturn Flight Count"+counts[1]);
	 
	  
  }
  
  @Test(priority=2)
  public void NoStopsFlightCount()
  {
	  pageObj=HomePage.obj;
	  System.out.println("*****Flight Count when Non Stop checkbox is selected*****");
	  counts=pageObj.NoStopFlightCount();
	  System.out.println("Depature Flght count:"+counts[0]+"\nReturn Flight Count"+counts[1]);
  }
  
  @Test(priority=3)
  public void OnStopFlightCount()
  {
	  pageObj=HomePage.obj;
	  System.out.println("*****Flight Count when 1 Stop checkbox is selected*****");
	  counts=pageObj.oneStopFlightCount();
	  System.out.println("Depature Flght count:"+counts[0]+"\nReturn Flight Count"+counts[1]);
  }
}
