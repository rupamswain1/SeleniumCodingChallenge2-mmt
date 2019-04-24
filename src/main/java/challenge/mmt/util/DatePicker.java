package challenge.mmt.util;

import java.util.Calendar;

import challenge2.mmt.ReadProperty.ReadPropertyFile;

public class DatePicker {
	
	
	private String departureDate=null;
	private String returnDate=null;
	
	public String getDepartureDate() {
		return departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	//Picks up current system for Departure DAte and +7 days for Return date Retursn in format tue 13 Apr 2019
	public static DatePicker getDates()
	{
		DatePicker date=new DatePicker();
		Calendar cal=Calendar.getInstance();
		
		String[] rawDate=cal.getTime().toString().split(" ");
		date.departureDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		cal.add(Calendar.DATE, Integer.parseInt(ReadPropertyFile.get("NoOfdays")));
		rawDate=cal.getTime().toString().split(" ");
		date.returnDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		return date;
	}

	
}
