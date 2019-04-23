package challenge2.mmt.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import challenge2.mmt.WebPages.FlightResultPage;
import challenge2.mmt.WebPages.HomePage;

import java.util.Map;
import java.util.Random;


import org.testng.annotations.DataProvider;

public class FlightPrices {
	
	public Long numericalPrice(String Price)
	{
		Long NumPrice=Long.parseLong(Price.replaceAll("[^\\d.]", ""));
		return NumPrice;		
	}

	@Test(dataProvider="dp")
	public void FlightPrice(String ret, String dep)
	{
		FlightResultPage pageObj=HomePage.obj;
		Map<String, String> prices=pageObj.selectRandomFlight(Integer.parseInt(ret), Integer.parseInt(dep));
		SoftAssert softAssert=new SoftAssert();

		softAssert.assertEquals(numericalPrice(prices.get("Dep Flight")), numericalPrice(prices.get("Dep Bottom Price")));
		softAssert.assertEquals(numericalPrice(prices.get("Ret Flight")), numericalPrice(prices.get("Ret Bottom Price")));
		Long expectedTotal=numericalPrice(prices.get("Dep Bottom Price"))+numericalPrice(prices.get("Ret Bottom Price"));
		
		softAssert.assertEquals(numericalPrice(prices.get("total Price")),expectedTotal);
		softAssert.assertAll();
	}
	
	@DataProvider
	public String[][] dp()
	{
		String[][] data= new String[3][2];
		Random rand=new Random();
		FlightResultPage pageObj=HomePage.obj;
		pageObj.clearFilter();
		int Depcount=pageObj.departureFilightCount();
		int retCount=pageObj.returnFilightCount();
		for(int i=0;i<3;i++)
		{
			
			
			if(Depcount>10)
			{
				data[i][0]=rand.nextInt(11)+"";
			}
			else
			{
				data[i][0]=rand.nextInt(Depcount)+"";
			}
			if(retCount>10)
			{
				data[i][1]=rand.nextInt(11)+"";
			}
			else
			{
				data[i][1]=rand.nextInt(retCount)+"";
			}
			
		}
		
		return data;
	}
}
