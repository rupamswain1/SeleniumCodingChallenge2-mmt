package challenge2.mmt.tests;

import org.testng.annotations.Test;


import challenge2.mmt.WebPages.HomePage;

public class SearchFlightTest {
//Searches flight by providing FROM,TO , DEPARTURE and RETURN details
  @Test
  public void searchFlights() 
  {
	 HomePage homePage= new HomePage();
	 homePage.Search();
  }
}
