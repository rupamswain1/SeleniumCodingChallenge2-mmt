package challenge2.mmt.WebPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import challenge.mmt.Browser.Driver;
import challenge.mmt.util.DatePicker;
import challenge.mmt.util.DynamicXpath;
import challenge.mmt.util.Wait;
import challenge2.mmt.ReadProperty.ReadPropertyFile;

/**
 * @author RUPAM
 *
 */
public class HomePage {

	@FindBy(xpath="//a[contains(@href,'flights') and contains(@class,'hrtlCenter')]")
	WebElement FlightsTab;
	
	@FindBy(xpath="//li[contains(text(),'Round Trip')]/child::span")
	WebElement RoundTrip;
	
	@FindBy(xpath="//input[@id='fromCity']")
	WebElement FromCity;
	
	@FindBy(xpath="//input[@placeholder='From']")
	WebElement FromCityEnter;
		
	@FindBy(xpath="//input[@placeholder='To']")
	WebElement ToCityEnter;
	
	@FindBy(xpath="//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']")
	WebElement autosuggestFirstOption;
	
	@FindBy(xpath="//label[@for='departure']")
	WebElement departureDate;
	
	@FindBy(xpath="//label[@for='return']")
	WebElement returnDate;
			
	@FindBy(xpath="//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']")
	WebElement search;
	
	
	String datePickerXpath="//div[@aria-label='%replacable%' and @aria-disabled='false']";
	String TripTypexpath="//li[contains(text(),'%replacable%')]/child::span";
	
	public static FlightResultPage obj=null;
	
	public HomePage()
	{
		PageFactory.initElements(Driver.driver, this);
	}
	
	//Searches for flight by entering FROM,TO, DEPARTURE and RETURN details
	public FlightResultPage Search() 
	{
		FlightsTab.click();
		Driver.driver.findElement(DynamicXpath.get(TripTypexpath, ReadPropertyFile.get("Trip"))).click();
		FromCity.click();
		
		FromCityEnter.sendKeys(ReadPropertyFile.get("From"));
		Wait.toBeclickable2(autosuggestFirstOption, ReadPropertyFile.get("From"));
		autosuggestFirstOption.click();
		ToCityEnter.sendKeys(ReadPropertyFile.get("To"));
		departureDate.click();
		DatePicker date=DatePicker.getDates();
		Driver.driver.findElement(DynamicXpath.get(datePickerXpath, date.getDepartureDate())).click();
		Driver.driver.findElement(DynamicXpath.get(datePickerXpath, date.getReturnDate())).click();
		search.click();
		return HomePage.obj=new FlightResultPage();
	}
}
