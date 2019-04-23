package challenge2.mmt.tests;

import org.testng.annotations.Test;


import challenge2.mmt.WebPages.HomePage;

public class SearchFlightTest {
  @Test
  public void searchFlights() 
  {
	 HomePage homePage= new HomePage();
	 homePage.Search();
  }
}
